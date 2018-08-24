package machine.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import machine.data.entities.machines.dryers.RefrigerationDryer;
import machine.data.enums.MachineType;

public class RfDryerDto extends MachineDto {

	@NotNull 
	private Double volumetricFlowRate;
	@NotBlank 
	private String compressedAirConnection;

	public RfDryerDto() {
		super();
		setMachineType(MachineType.REFRIGERATION_DRYER);
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
		return RefrigerationDryer.class;
	}
}
