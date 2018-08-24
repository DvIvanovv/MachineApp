package machine.services;

import java.util.List;

import org.springframework.stereotype.Service;

import machine.data.entities.Consumable;
import machine.dto.ServiceOrderDto;

@Service
public interface ServiceOrderService {
	void addServiceOrder(ServiceOrderDto serviceOrderDto);

	List<ServiceOrderDto> getAllServiceOrdersByUser(String username);
}
