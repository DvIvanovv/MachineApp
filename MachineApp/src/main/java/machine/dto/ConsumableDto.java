package machine.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import machine.data.entities.machines.Machine;
import machine.data.enums.ConsumableType;


public class ConsumableDto {

	private Long id;

	@NotNull
	private ConsumableType consumableType;
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
