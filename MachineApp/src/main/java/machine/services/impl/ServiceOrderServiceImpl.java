package machine.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import machine.data.entities.Consumable;
import machine.data.entities.ServiceOrder;
import machine.data.repository.ServiceOrderRepository;
import machine.dto.ServiceOrderDto;
import machine.services.ServiceOrderService;

@Service
public class ServiceOrderServiceImpl implements ServiceOrderService {

	private ServiceOrderRepository serviceOrderRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public ServiceOrderServiceImpl(ServiceOrderRepository serviceOrderRepository, ModelMapper modelMapper) {
		super();
		this.serviceOrderRepository = serviceOrderRepository;
		this.modelMapper = modelMapper;
	}


	@Override
	public void addServiceOrder(ServiceOrderDto serviceOrderDto) {
		if(!checkDate(serviceOrderDto.getServiceDate())) {
			throw new  IllegalArgumentException (
					"Service date must be within 30 days after today!");
		}
		
		ServiceOrder serviceOrder = modelMapper.map(serviceOrderDto, ServiceOrder.class);
		this.serviceOrderRepository.save(serviceOrder);
	}
	
	@Override
	public List<ServiceOrderDto> getAllServiceOrdersByUser(String username) {
		List<ServiceOrder> serviceOrders = this.serviceOrderRepository.findAllByUserUsername(username);
		List<ServiceOrderDto> result = new ArrayList<>();
		for(ServiceOrder s : serviceOrders) {
			ServiceOrderDto so = new ServiceOrderDto();
			so = modelMapper.map(s, ServiceOrderDto.class);
			so.setForMachine(s.getWarranty().getMachine().getModel());
//			for(Consumable c : s.getAccsesories()) {
//				String consumable = c.getAccessoryType().toString();
//				so.getConsumables().add(consumable);
//			}
			result.add(so);
		}
		return result;
	}


	private boolean checkDate(Date date) {
		
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE ,1);
		Date currentDateTomorrow =c.getTime();
		c.add(Calendar.DATE ,30);
		Date currentDatePlusOneMonth = c.getTime();
//		c.add(Calendar.DATE ,-60);
//		Date currentDateMinusOneMonth = c.getTime();
		if(date.after(currentDatePlusOneMonth) || date.before(currentDateTomorrow)) {
			return false;
		}
		c.setTime(date);
		if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return false;
		}
		return true;
	}
	
	
	
}
