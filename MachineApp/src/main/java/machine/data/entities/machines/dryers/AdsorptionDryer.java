package machine.data.entities.machines.dryers;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Adsorbtion")
public class AdsorptionDryer extends Dryer{
	
}
