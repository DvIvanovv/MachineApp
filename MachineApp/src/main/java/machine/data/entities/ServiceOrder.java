package machine.data.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "service_orders")
public class ServiceOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "compressor_id", referencedColumnName = "id")
	private Machine compressor;
	
	@OneToMany
	@JoinTable(name = "service_order_accessories")
	
	List<Accessory> accsesories =new ArrayList<Accessory>();

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
	 * @return the compressor
	 */
	public Machine getCompressor() {
		return compressor;
	}

	/**
	 * @param compressor the compressor to set
	 */
	public void setCompressor(Machine compressor) {
		this.compressor = compressor;
	}

	/**
	 * @return the accsesories
	 */
	public List<Accessory> getAccsesories() {
		return accsesories;
	}

	/**
	 * @param accsesories the accsesories to set
	 */
	public void setAccsesories(List<Accessory> accsesories) {
		this.accsesories = accsesories;
	}
	
	
	
}
