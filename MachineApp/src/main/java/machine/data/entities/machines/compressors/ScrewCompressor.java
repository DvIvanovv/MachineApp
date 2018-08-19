package machine.data.entities.machines.compressors;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import machine.data.entities.machines.dryers.AdsorptionDryer;
import machine.dto.ScrewCompressorDto;

@Entity
@DiscriminatorValue("Screw")
public class ScrewCompressor extends Compressor {

	@Column(name="volume_at_8_bars")
	@NotNull
	protected Double volumeAt8Bars;
	@Column(name="volume_at_10_bars")
	@NotNull
	protected Double volumeAt10Bars;
	@Column(name="volume_at_13_bars")
	@NotNull
	protected Double volumeAt13Bars;
	
	/**
	 * @return the volumeAt8Bars
	 */
	public Double getVolumeAt8Bars() {
		return volumeAt8Bars;
	}
	/**
	 * @param volumeAt8Bars the volumeAt8Bars to set
	 */
	public void setVolumeAt8Bars(Double volumeAt8Bars) {
		this.volumeAt8Bars = volumeAt8Bars;
	}
	/**
	 * @return the volumeAt10Bars
	 */
	public Double getVolumeAt10Bars() {
		return volumeAt10Bars;
	}
	/**
	 * @param volumeAt10Bars the volumeAt10Bars to set
	 */
	public void setVolumeAt10Bars(Double volumeAt10Bars) {
		this.volumeAt10Bars = volumeAt10Bars;
	}
	/**
	 * @return the volumeAt13Bars
	 */
	public Double getVolumeAt13Bars() {
		return volumeAt13Bars;
	}
	/**
	 * @param volumeAt13Bars the volumeAt13Bars to set
	 */
	public void setVolumeAt13Bars(Double volumeAt13Bars) {
		this.volumeAt13Bars = volumeAt13Bars;
	}
	
	public Class getMappedClass() {
		return ScrewCompressorDto.class;
	}
	
}
