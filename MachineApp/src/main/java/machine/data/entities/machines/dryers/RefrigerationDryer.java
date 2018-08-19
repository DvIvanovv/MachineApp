package machine.data.entities.machines.dryers;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import machine.dto.RfDryerDto;

@Entity
@DiscriminatorValue("Refrigeration")
public class RefrigerationDryer extends Dryer{
	
	public Class getMappedClass() {
		return RfDryerDto.class;
	}
}
