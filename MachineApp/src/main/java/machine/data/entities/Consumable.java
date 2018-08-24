package machine.data.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import machine.data.entities.machines.Machine;
import machine.data.enums.AccessoryType;

@Entity   
@Table(name="accessories")
public class Consumable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "accessory_type")
	private AccessoryType accessoryType;
	@NotBlank
	private String name;
	@ManyToMany(cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinTable(name = "accessory_machine")
	private List<Machine> machines;



	public Consumable() {
		super();
		this.machines = new ArrayList<>();
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the accessoryType
	 */
	public AccessoryType getAccessoryType() {
		return accessoryType;
	}
	/**
	 * @param accessoryType the accessoryType to set
	 */
	public void setAccessoryType(AccessoryType accessoryType) {
		this.accessoryType = accessoryType;
	}
	/**
	 * @return the machines
	 */
	public List<Machine> getMachines() {
		return machines;
	}
	/**
	 * @param machines the machines to set
	 */
	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	



}
