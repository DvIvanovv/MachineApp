package machine.data.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import machine.data.entities.machines.Machine;
import machine.data.enums.ConsumableType;

@Entity   
@Table(name="consumables")
public class Consumable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "consumable_type")
	private ConsumableType consumableType;
	@NotBlank
	private String name;
	@ManyToMany(cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinTable(name = "consumable_machine")
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
	 * @return the consumableType
	 */
	public ConsumableType getConsumableType() {
		return consumableType;
	}
	/**
	 * @param consumableType the consumableType to set
	 */
	public void setConsumableType(ConsumableType consumableType) {
		this.consumableType = consumableType;
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
