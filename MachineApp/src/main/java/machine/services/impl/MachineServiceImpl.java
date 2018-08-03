package machine.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import machine.data.entities.machines.Machine;
import machine.data.repository.MachineRepository;
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
		Machine machine = (Machine)mapper.map(machineDto, machineDto.getMappedClass());
		this.machineRepository.save(machine);
	}




	@Override
	public List<Machine> getAllMachines() {	
		return (List<Machine>)this.machineRepository.findAll();
	}
	
	

}
