package machine.dto;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import machine.data.entities.Warranty;
import machine.data.enums.MachineType;

public class MachineDto {
	@Id
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
	
	protected Warranty waranty;
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
	public Warranty getWaranty() {
		return waranty;
	}
	public void setWaranty(Warranty waranty) {
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
