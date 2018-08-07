package machine.dto;


import javax.validation.constraints.NotNull;
import machine.data.entities.machines.compressors.ScrewCompressor;
import machine.data.enums.MachineType;

public class ScrewCompressorDto extends MachineDto {


	@NotNull
	private Double volumeAt8Bars;
	@NotNull
	private Double volumeAt10Bars;
	@NotNull
	private Double volumeAt13Bars;

	public ScrewCompressorDto() {
		super();
		setMachineType(MachineType.SCREW_COMPRESSOR);
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
	@Override
	public Class getMappedClass() {

		return ScrewCompressor.class;
	}

}
