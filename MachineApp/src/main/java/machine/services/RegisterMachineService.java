package machine.services;

import org.springframework.stereotype.Service;

import machine.dto.RegisterMachineDto;

@Service
public interface RegisterMachineService {
	
	public void registerWarranty(RegisterMachineDto machine);
}
