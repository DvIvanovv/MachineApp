package machine.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import machine.data.entities.Consumable;
import machine.data.entities.machines.Machine;
import machine.data.enums.AccessoryType;
import machine.data.repository.AccessoryRepository;
import machine.dto.ConsumableDto;
import machine.services.ConsumableService;
import machine.services.MachineService;

@Service
public class ConsumableServiceImpl implements ConsumableService{

	private AccessoryRepository accessoryRepository;
	private ModelMapper modelMapper;
	private MachineService machineService;
	@Autowired
	public ConsumableServiceImpl(AccessoryRepository accessoryRepository,  ModelMapper modelMapper, MachineService machineService) {
		super();
		this.accessoryRepository = accessoryRepository;
		this.modelMapper = modelMapper;
		this.machineService =  machineService;
	}


	/* (non-Javadoc)
	 * @see machine.services.AccessoryService#addAccessory(machine.dto.AccessoryDto)
	 */
	@Override
	public void addAccessory(ConsumableDto accessoryDto) {
		
		Consumable accessory = modelMapper.map(accessoryDto, Consumable.class);
		this.accessoryRepository.save(accessory);
	}


	@Override
	public Consumable findByType(AccessoryType type) {
		
		return this.accessoryRepository.findByAccessoryType(type);
	}


//	@Override
//	public List<Accessory> findAllByModel(Machine machine) {
//		this.accessoryRepository.findAllByMachines(machine);
//		return null;
//	}
	
	



}
