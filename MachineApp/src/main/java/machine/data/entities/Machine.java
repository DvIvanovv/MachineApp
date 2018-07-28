package machine.data.entities;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import machine.data.enums.CompressorType;

@Entity
@Table(name="compressors")
public class Machine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
	@NotBlank
	private String model;
	@Column(name="compressor_type")
	@NotBlank
	private CompressorType compressorType;
	@Basic
	@NotBlank
	private Double power;
	@Basic
	@NotBlank
	private String dimension;
	@Basic
	@NotBlank
	private Double weigth;
	@Column(name="volume_at_8_bars")
	@NotBlank
	private Double volumeAt8Bars;
	@Column(name="volume_at_10_bars")
	@NotBlank
	private Double volumeAt10Bars;
	@Column(name="volume_at_12_bars")
	@NotBlank
	private Double volumeAt12Bars;
	@OneToOne
	@JoinColumn(name = "waranty_id", referencedColumnName = "id")
	private Waranty waranty;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the power
	 */
	public Double getPower() {
		return power;
	}
	/**
	 * @param power the power to set
	 */
	public void setPower(Double power) {
		this.power = power;
	}
	/**
	 * @return the dimension
	 */
	public String getDimension() {
		return dimension;
	}
	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	/**
	 * @return the weigth
	 */
	public Double getWeigth() {
		return weigth;
	}
	/**
	 * @param weigth the weigth to set
	 */
	public void setWeigth(Double weigth) {
		this.weigth = weigth;
	}
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
	 * @return the volumeAt12Bars
	 */
	public Double getVolumeAt12Bars() {
		return volumeAt12Bars;
	}
	/**
	 * @param volumeAt12Bars the volumeAt12Bars to set
	 */
	public void setVolumeAt12Bars(Double volumeAt12Bars) {
		this.volumeAt12Bars = volumeAt12Bars;
	}
	/**
	 * @return the compressorType
	 */
	public CompressorType getCompressorType() {
		return compressorType;
	}
	/**
	 * @param compressorType the compressorType to set
	 */
	public void setCompressorType(CompressorType compressorType) {
		this.compressorType = compressorType;
	}
	/**
	 * @return the waranty
	 */
	public Waranty getWaranty() {
		return waranty;
	}
	/**
	 * @param waranty the waranty to set
	 */
	public void setWaranty(Waranty waranty) {
		this.waranty = waranty;
	}
	
	
	
}
