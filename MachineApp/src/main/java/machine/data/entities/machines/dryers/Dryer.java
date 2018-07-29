package machine.data.entities.machines.dryers;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import machine.data.entities.machines.Machine;
import machine.data.enums.DryerType;

@MappedSuperclass
public class Dryer extends Machine {

	@Column(name = "volumetric_flow_rate")
	@NotNull
	private Double volumetricFlowRate;

	@Column(name = "compressed_air_connection")
	@NotBlank
	private String compressedAirConnection;


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
	
	
}
