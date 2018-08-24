package machine.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import machine.data.entities.machines.compressors.PistonCompressor;
import machine.data.enums.MachineType;

public class PistonCompressorDto extends MachineDto {

	@NotNull
	@Min(value =1)
	protected Short numberOfPistons;
	@NotNull
	@Min(value =1)
	protected Short numberOfStages;

	public PistonCompressorDto() {
		super();
		setMachineType(MachineType.PISTON_COMPRESSOR);
	}



	public Short getNumberOfPistons() {
		return numberOfPistons;
	}



	public void setNumberOfPistons(Short numberOfPistons) {
		this.numberOfPistons = numberOfPistons;
	}



	public Short getNumberOfStages() {
		return numberOfStages;
	}



	public void setNumberOfStages(Short numberOfStages) {
		this.numberOfStages = numberOfStages;
	}
	@Override
	public Class getMappedClass() {
		return PistonCompressor.class;
	}
}
