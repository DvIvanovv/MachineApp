package machine.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import machine.data.entities.Warranty;
import machine.data.entities.machines.Machine;
import machine.data.repository.RegisterWarrantyRepository;
import machine.dto.RegisterMachineDto;
import machine.services.MachineService;
import machine.services.RegisterMachineService;
@Service
public class RegisterMachineServiceImpl implements RegisterMachineService {
	
	private RegisterWarrantyRepository registerWarrantyRepository;
	private MachineService machineService;
	private ModelMapper modelMapper;
	@Autowired
	public RegisterMachineServiceImpl(RegisterWarrantyRepository registerWarrantyRepository,
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
	public void registerWarranty(RegisterMachineDto registerMachine) {
		Warranty warranty = modelMapper.map(registerMachine, Warranty.class);
		Machine machine = machineService.findByModel(registerMachine.getMachine());
		warranty.setMachine(machine);
		this.registerWarrantyRepository.save(warranty);
		
	}
	
	
	
	
	
	
}
