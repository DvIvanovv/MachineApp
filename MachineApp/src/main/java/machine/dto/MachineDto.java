package machine.dto;

import javax.validation.constraints.*;
import machine.data.entities.Waranty;
import machine.data.enums.MachineType;

public class MachineDto {
	
	protected Long id;

	protected String machineIdentifier;
	@NotNull
	@Size(min = 2, max = 10)
	protected String model;
	@NotNull
	@Max(1000)
	@Min(1)
	protected Double power;
	@NotNull (message = "Въведете стойност")
	protected Double powerConsumption;
	@NotNull
	@Size(min = 6, max = 15)
	protected String dimension;
	@NotNull
	@Max(1000)
	@Min(1)
	protected Double weigth;
	
	protected Waranty waranty;
	@NotNull (message = "Въведете стойност")
	protected MachineType machineType;
	
	
	
	public MachineDto() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMachineIdentifier() {
		return machineIdentifier;
	}
	public void setMachineIdentifier(String machineIdentifier) {
		this.machineIdentifier = machineIdentifier;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Double getPower() {
		return power;
	}
	public void setPower(Double power) {
		this.power = power;
	}
	public Double getPowerConsumption() {
		return powerConsumption;
	}
	public void setPowerConsumption(Double powerConsumption) {
		this.powerConsumption = powerConsumption;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public Double getWeigth() {
		return weigth;
	}
	public void setWeigth(Double weigth) {
		this.weigth = weigth;
	}
	public Waranty getWaranty() {
		return waranty;
	}
	public void setWaranty(Waranty waranty) {
		this.waranty = waranty;
	}
	public MachineType getMachineType() {
		return machineType;
	}
	public void setMachineType(MachineType machineType) {
		this.machineType = machineType;
	}
	
	public  Class getMappedClass() {
		return null;
	}	
	
}
