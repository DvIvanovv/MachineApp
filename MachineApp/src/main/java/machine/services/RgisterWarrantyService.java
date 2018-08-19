package machine.services;

import java.util.List;

import org.springframework.stereotype.Service;

import machine.data.entities.Warranty;
import machine.dto.WarrantyDto;

@Service
public interface RgisterWarrantyService {
	
	public void registerWarranty(WarrantyDto machine);
	
	public List<WarrantyDto> findAllByUser(String userName);
	
	public Warranty findBySerialNumber(String serialNumber);

	public boolean isSerialNumberExists(String serialNumber);
	public List<Warranty> getAllWarranties();
	public void approvedWarranty(Warranty warranty);
}
