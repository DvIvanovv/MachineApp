package machine.services;


import org.springframework.stereotype.Service;

import machine.dto.AccessoryDto;

@Service
public interface AccessoryService {

	public void addAccessory(AccessoryDto accessoryDto);

}
