package machine.data.entities.machines.dryers;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import machine.dto.AdDryerDto;
import machine.dto.PistonCompressorDto;

@Entity
@DiscriminatorValue("Adsorbtion")
public class AdsorptionDryer extends Dryer{
	public Class getMappedClass() {
		return AdDryerDto.class;
	}
}
