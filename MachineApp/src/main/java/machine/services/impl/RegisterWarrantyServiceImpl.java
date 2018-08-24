package machine.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import machine.data.entities.Warranty;
import machine.data.entities.machines.Machine;
import machine.data.repository.WarrantyRepository;
import machine.dto.WarrantyDto;
import machine.services.MachineService;
import machine.services.RgisterWarrantyService;
@Service
public class RegisterWarrantyServiceImpl implements RgisterWarrantyService {
	
	private WarrantyRepository registerWarrantyRepository;
	private MachineService machineService;
	private ModelMapper modelMapper;
	@Autowired
	public RegisterWarrantyServiceImpl(WarrantyRepository registerWarrantyRepository,
			ModelMapper modelMapper, MachineService machineService) {
		super();
		this.registerWarrantyRepository = registerWarrantyRepository;
		this.modelMapper = modelMapper;
		this.machineService = machineService;
	}
	/* (non-Javadoc)
	 * @see machine.services.RegisterMachineService#registerWarranty(machine.dto.RegisterMachineDto)
	 */
	@Override
	public void registerWarranty(WarrantyDto registerMachine) {
		if(isSerialNumberExists(registerMachine.getSerialNumber())) {
			throw new  IllegalArgumentException (
					"There is a warranty with serial number: "
							+ registerMachine.getSerialNumber());
		}
		if(!checkDate(registerMachine.getOrderDate())) {
			throw new  IllegalArgumentException (
					"Register date must be within 30 days after order date and can not be in the future");
		}
		Warranty warranty = modelMapper.map(registerMachine, Warranty.class);
		warranty.setMachine(this.machineService.findByModel(registerMachine.getMachine()));
		this.registerWarrantyRepository.save(warranty);
		
	}
	@Override
	public List<WarrantyDto> findAllByUser(String userName) {
		List<Warranty> temp = this.registerWarrantyRepository.findAllByUsername(userName);
		List<WarrantyDto> result = new ArrayList<>();
		for(Warranty w : temp) {
			WarrantyDto wDto = new WarrantyDto();
			wDto= modelMapper.map(w, WarrantyDto.class);
			Machine m = w.getMachine();
			wDto.setMachine(m.getModel());
			//wDto.setSerialNumber(w.getSerialNumber());
			result.add(wDto);
		}
		return result;
	}
	@Override
	public Warranty findBySerialNumber(String serialNumber) {
	
		return this.registerWarrantyRepository.findBySerialNumber(serialNumber);
	}
	
	@Override
	public boolean isSerialNumberExists(String serialNumber) {
		if(this.registerWarrantyRepository.findBySerialNumber(serialNumber) != null) {
			return true;
		}
		return false;
	}
	
	private boolean checkDate(Date date) {
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE , -30);
		Date currentDateMinusOneMonth = c.getTime();
		if(date.before(currentDateMinusOneMonth) || date.after(currentDate)) {
			return false;
		}
		
		return true;
		
	}
	@Override
	public List<Warranty> getAllWarranties(){
		return (List<Warranty>)this.registerWarrantyRepository.findAll();
	}
	@Override
	public void approvedWarranty(Warranty warranty) {
		this.registerWarrantyRepository.save(warranty);
		
	}
	@Override
	@Async
	public CompletableFuture<String> countMachineSales(String machineModel) {
		List<Warranty> result = this.registerWarrantyRepository.findAllByMachineModel(machineModel);
		return CompletableFuture.completedFuture("Machine model: " + machineModel + " is sold " + result.size() + " times.");
	}
		
}
