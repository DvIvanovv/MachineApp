package machine.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import machine.data.entities.Waranty;
import machine.data.entities.machines.compressors.PistonCompressor;
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
		// TODO Auto-generated method stub
		return AdsorptionDryer.class;
	}
}
