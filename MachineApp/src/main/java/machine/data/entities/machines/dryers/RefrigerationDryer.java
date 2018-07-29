package machine.data.entities.machines.dryers;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Refrigeration")
public class RefrigerationDryer extends Dryer{

}
