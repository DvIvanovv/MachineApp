package machine.data.entities.machines.compressors;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import machine.data.entities.machines.dryers.AdsorptionDryer;
import machine.dto.PistonCompressorDto;

@Entity
@DiscriminatorValue("Piston")
public class PistonCompressor extends Compressor {
	@NotNull
	@Column(name = "number_of_pistons")
	protected short numberOfPistons;
	@Column(name = "number_of_stages")
	@NotNull
	protected short numberOfstage;
	
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
	public Class getMappedClass() {
		return PistonCompressorDto.class;
	}
	
}
