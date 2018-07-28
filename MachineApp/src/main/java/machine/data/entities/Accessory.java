package machine.data.entities;

import javax.persistence.*;

import machine.data.enums.AccessoryType;

@Entity   
@Table(name="accessories")
public class Accessory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "accessory_type")
	private AccessoryType accessoryType;
	
	
	

}
