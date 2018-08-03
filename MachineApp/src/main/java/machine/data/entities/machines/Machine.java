package machine.data.entities.machines;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import machine.data.enums.MachineType;

@Entity
@Table(name="machines")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "machine_identifier")
public class Machine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@Column(name="machine_identifier", insertable = false, updatable = false)
	protected String machineIdentifier;
	@Basic
	@NotBlank
	protected String model;
	@Basic
	@NotNull
	protected Double power;
	@Column(name = "power_consumption")
	@NotNull
	protected Double powerConsumption;
	@Basic
	@NotBlank
	protected String dimension;
	@Basic
	@NotNull
	protected Double weigth;	
	@Column(name="machine_type")
	@NotNull
	protected MachineType machineType;
	@Basic
	protected byte[] image;
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
	public Double getPowerConsumption() {
		return powerConsumption;
	}
	public void setPowerConsumption(Double powerConsumption) {
		this.powerConsumption = powerConsumption;
	}
	public MachineType getMachineType() {
		return machineType;
	}
	public void setMachineType(MachineType machineType) {
		this.machineType = machineType;
	}
	public String getMachineIdentifier() {
		return machineIdentifier;
	}
	public void setMachineIdentifier(String machineIdentifier) {
		this.machineIdentifier = machineIdentifier;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
}
