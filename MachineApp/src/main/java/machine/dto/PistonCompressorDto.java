package machine.dto;

import javax.validation.constraints.NotNull;

import machine.data.entities.machines.compressors.PistonCompressor;
import machine.data.enums.MachineType;

public class PistonCompressorDto extends MachineDto {

	@NotNull
	protected short numberOfPistons;
	@NotNull
	protected short numberOfstage;


	public PistonCompressorDto() {
		super();
		setMachineType(MachineType.PISTON_COMPRESSOR);
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
	@Override
	public Class getMappedClass() {
		// TODO Auto-generated method stub
		return PistonCompressor.class;
	}



}
