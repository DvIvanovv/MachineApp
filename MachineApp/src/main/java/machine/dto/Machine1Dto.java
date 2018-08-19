package machine.dto;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import machine.data.entities.Warranty;
import machine.data.entities.machines.compressors.PistonCompressor;
import machine.data.entities.machines.compressors.ScrewCompressor;
import machine.data.entities.machines.dryers.AdsorptionDryer;
import machine.data.entities.machines.dryers.RefrigerationDryer;
import machine.data.enums.MachineType;

public class Machine1Dto {
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
	
	protected MachineType machineType;

	protected short numberOfPistons;

	protected short numberOfstage;
	
	private Double volumetricFlowRate;

	private String compressedAirConnection;
	
	private Double volumeAt8Bars;
	
	private Double volumeAt10Bars;
	
	private Double volumeAt13Bars;
	
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
	public short getNumberOfPistons() {
		return numberOfPistons;
	}
	public void setNumberOfPistons(short numberOfPistons) {
		this.numberOfPistons = numberOfPistons;
	}
	public short getNumberOfstage() {
		return numberOfstage;
	}
	public void setNumberOfstage(short numberOfstage) {
		this.numberOfstage = numberOfstage;
	}
	public Double getVolumetricFlowRate() {
		return volumetricFlowRate;
	}
	public void setVolumetricFlowRate(Double volumetricFlowRate) {
		this.volumetricFlowRate = volumetricFlowRate;
	}
	public String getCompressedAirConnection() {
		return compressedAirConnection;
	}
	public void setCompressedAirConnection(String compressedAirConnection) {
		this.compressedAirConnection = compressedAirConnection;
	}
	public Double getVolumeAt8Bars() {
		return volumeAt8Bars;
	}
	public void setVolumeAt8Bars(Double volumeAt8Bars) {
		this.volumeAt8Bars = volumeAt8Bars;
	}
	public Double getVolumeAt10Bars() {
		return volumeAt10Bars;
	}
	public void setVolumeAt10Bars(Double volumeAt10Bars) {
		this.volumeAt10Bars = volumeAt10Bars;
	}
	public Double getVolumeAt13Bars() {
		return volumeAt13Bars;
	}
	public void setVolumeAt13Bars(Double volumeAt13Bars) {
		this.volumeAt13Bars = volumeAt13Bars;
	}
	
	public Class getMappedClass() {
		switch(this.getMachineType().name()) {
		case "SCREW_COMPRESSOR" : 	
					return ScrewCompressor.class;
		case "PISTON_COMPRESSOR" : 
			return PistonCompressor.class;
		case "ADSORPTION_DRYER" : 
			return AdsorptionDryer.class;
		case "REFRIGERATION_DRYER" : 
			return RefrigerationDryer.class;
			default:
				break;
		}
		return null;
	}
	
}
