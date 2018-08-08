package machine.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import machine.data.enums.AccessoryType;


public class AccessoryDto {

	private Long id;

	@NotNull
	private AccessoryType accessoryType;
	@NotEmpty
	private List<String> machines;

	public AccessoryDto() {
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
	public List<String> getMachines() {
		return machines;
	}
	/**
	 * @param machines the machines to set
	 */
	public void setMachines(List<String> machines) {
		this.machines = machines;
	}
}
