package machine.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import machine.data.entities.machines.Machine;
import machine.data.enums.AccessoryType;


public class ConsumableDto {

	private Long id;

	@NotNull
	private AccessoryType accessoryType;
	@NotBlank
	private String name;
	@NotEmpty
	private List<Machine> machines;

	public ConsumableDto() {
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
