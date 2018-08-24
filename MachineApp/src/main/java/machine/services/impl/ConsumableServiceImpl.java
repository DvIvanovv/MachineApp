package machine.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import machine.data.entities.Consumable;
import machine.data.entities.machines.Machine;
import machine.data.enums.ConsumableType;
import machine.data.repository.ConsumableRepository;
import machine.dto.ConsumableDto;
import machine.services.ConsumableService;

@Service
public class ConsumableServiceImpl implements ConsumableService{

	private ConsumableRepository consumableRepository;
	private ModelMapper modelMapper;
	@Autowired
	public ConsumableServiceImpl(ConsumableRepository consumableRepository,  ModelMapper modelMapper) {
		super();
		this.consumableRepository = consumableRepository;
		this.modelMapper = modelMapper;
	}


	/* (non-Javadoc)
	 * @see machine.services.ConsumableService#addConsumable(machine.dto.ConsumableDto)
	 */
	@Override
	public boolean addConsumable(ConsumableDto consumableDto) {
		
		if(isConsumableExist(consumableDto.getName())) {
			Consumable temp = this.consumableRepository.findByName(consumableDto.getName());
			List<Machine> machinsToBeAdd = consumableDto
					.getMachines()
					.stream()
					.filter(m -> temp.getMachines().stream()
							.noneMatch(m1 -> m.getModel().equals(m1.getModel()))).collect(Collectors.toList());
			if(machinsToBeAdd.size() > 0) {
				temp.getMachines().addAll(machinsToBeAdd);
				this.consumableRepository.save(temp);
				consumableDto.getMachines().clear();
				consumableDto.setMachines(machinsToBeAdd);
				return true;
			}
			return false;
		}
		Consumable consumable = modelMapper.map(consumableDto, Consumable.class);
		this.consumableRepository.save(consumable);
		return true;
	}


	@Override
	public Consumable findByType(ConsumableType type) {
		
		return this.consumableRepository.findByConsumableType(type);
	}
	
	private boolean isConsumableExist(String name) {
		if(this.consumableRepository.findByName(name) != null) {
			return true;
		}
		return false;
	}



}
