package machine.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import machine.data.entities.Accessory;
import machine.data.entities.machines.Machine;
import machine.data.repository.AccessoryRepository;
import machine.dto.AccessoryDto;
import machine.services.AccessoryService;
import machine.services.MachineService;

@Service
public class AccessoryServiceImpl implements AccessoryService{

	private AccessoryRepository accessoryRepository;
	private ModelMapper modelMapper;
	private MachineService machineService;
	@Autowired
	public AccessoryServiceImpl(AccessoryRepository accessoryRepository,  ModelMapper modelMapper, MachineService machineService) {
		super();
		this.accessoryRepository = accessoryRepository;
		this.modelMapper = modelMapper;
		this.machineService =  machineService;
	}


	/* (non-Javadoc)
	 * @see machine.services.AccessoryService#addAccessory(machine.dto.AccessoryDto)
	 */
	@Override
	public void addAccessory(AccessoryDto accessoryDto) {
		
		Accessory accessory = modelMapper.map(accessoryDto, Accessory.class);
		List<Machine> machines = new ArrayList<>();
		for(String machine : accessoryDto.getMachines()) {
			if(this.machineService.findByModel(machine)!= null) {
				machines.add(this.machineService.findByModel(machine));
			}
		}
		accessory.setMachines(machines);
		this.accessoryRepository.save(accessory);


	}



}
