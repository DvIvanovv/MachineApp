package machine.dto;

import javax.validation.constraints.NotNull;

import machine.data.entities.machines.dryers.AdsorptionDryer;
import machine.data.enums.MachineType;

public class AdDryerDto extends MachineDto{

	@NotNull (message = "Въведете стойност")
	private Double volumetricFlowRate;
	@NotNull (message = "Въведете стойност")
	private String compressedAirConnection;
	
	public AdDryerDto() {
		super();
		setMachineType(MachineType.ADSORPTION_DRYER);
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
	@Override
	public Class getMappedClass() {
		return AdsorptionDryer.class;
	}
}
