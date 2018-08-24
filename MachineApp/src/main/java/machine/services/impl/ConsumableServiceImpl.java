package machine.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
	public boolean addAccessory(ConsumableDto accessoryDto) {
		
		if(isConsumableExist(accessoryDto.getName())) {
			Consumable temp = this.accessoryRepository.findByName(accessoryDto.getName());
			List<Machine> machinsToBeAdd = accessoryDto
					.getMachines()
					.stream()
					.filter(m -> temp.getMachines().stream()
							.noneMatch(m1 -> m.getModel().equals(m1.getModel()))).collect(Collectors.toList());
			if(machinsToBeAdd.size() > 0) {
				temp.getMachines().addAll(machinsToBeAdd);
				this.accessoryRepository.save(temp);
				accessoryDto.getMachines().clear();
				accessoryDto.setMachines(machinsToBeAdd);
				return true;
			}
			return false;
		}
		Consumable accessory = modelMapper.map(accessoryDto, Consumable.class);
		this.accessoryRepository.save(accessory);
//		accessory.setMachines(accessory
//				.getMachines()
//				.stream()
//				.filter(m -> m.getConsumables()
//						.stream()
//						.noneMatch(c-> c.getAccessoryType().equals(accessory.getAccessoryType()))).collect(Collectors.toList()));
		
//		if(accessory.getMachines().size() > 0) {
//			this.accessoryRepository.save(accessory);
//			accessoryDto.getMachines().clear();
//			accessoryDto.setMachines(accessory.getMachines());
			return true;
//		}		
//		return false;
	}


	@Override
	public Consumable findByType(AccessoryType type) {
		
		return this.accessoryRepository.findByAccessoryType(type);
	}


	@Override
	public Consumable findByMachineAndType(Long machineId, AccessoryType type) {
		
		return this.accessoryRepository.findByTypeAndMachine(machineId, type);
	}
	
	

//	@Override
//	public List<Accessory> findAllByModel(Machine machine) {
//		this.accessoryRepository.findAllByMachines(machine);
//		return null;
//	}
	
	private boolean isConsumableExist(String name) {
		if(this.accessoryRepository.findByName(name) != null) {
			return true;
		}
		return false;
	}



}
