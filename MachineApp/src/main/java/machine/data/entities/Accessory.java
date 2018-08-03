package machine.data.entities;

import java.util.List;

import javax.persistence.*;

import machine.data.entities.machines.Machine;
import machine.data.enums.AccessoryType;

@Entity   
@Table(name="accessories")
public class Accessory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "accessory_type")
	private AccessoryType accessoryType;
	@ManyToMany
	@JoinTable(name = "accessory_machine")
	private List<Machine> machines;
	
	

}
