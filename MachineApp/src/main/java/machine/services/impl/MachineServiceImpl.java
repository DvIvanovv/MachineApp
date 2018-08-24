package machine.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import machine.data.entities.machines.Machine;
import machine.data.enums.MachineType;
import machine.data.repository.MachineRepository;
import machine.dto.Machine1Dto;
import machine.dto.MachineDto;
import machine.services.MachineService;
@Transactional
@Service
public class MachineServiceImpl implements MachineService {

	private MachineRepository machineRepository;
	private ModelMapper mapper;
	@Autowired
	public MachineServiceImpl(MachineRepository machineRepository, ModelMapper mapper) {
		super();
		this.machineRepository = machineRepository;
		this.mapper =  mapper;
	}

	@Override
	public void addMachine(MachineDto machineDto) {
		if(isMachineExist(machineDto.getModel())) {
			throw new  IllegalArgumentException (
					"Machine with  model "
							+  machineDto.getModel() + " allready exists.");
		}
		Machine machine =(Machine) mapper.map(machineDto, machineDto.getMappedClass());
		this.machineRepository.save(machine);
	}
	
	public Machine findByModel(String model) {
		return this.machineRepository.findByModel(model);
	}




	@Override
	public List<Machine> getAllMachines() {	
		return (List<Machine>)this.machineRepository.findAll();
	}
	@Override
	public List<MachineDto> getAllMachinesDto() {	
		List<Machine> temp =(List<Machine>)this.machineRepository.findAll();
		List<MachineDto> result = new ArrayList<>();
		for(Machine m: temp) {
			MachineDto machine = (MachineDto)mapper.map(m, m.getMappedClass());
			result.add(machine);
		}
		return result;
	}
	
	

	/* (non-Javadoc)
	 * @see machine.services.MachineService#getAllMachinesByType(machine.data.enums.MachineType)
	 */
	@Override
	public List<Machine> getAllMachinesByType(MachineType machineType) {
		// TODO Auto-generated method stub
		return this.machineRepository.findAllByMachineType(machineType);
	}

	@Override
	public void addMachine(Machine1Dto machineDto) {
		Machine machine =(Machine) mapper.map(machineDto, machineDto.getMappedClass());
		this.machineRepository.save(machine);
		
	}
	
	private boolean isMachineExist(String model) {
		if(this.machineRepository.findByModel(model) != null) {
			return true;
		}
		return false;
	}
		
}
