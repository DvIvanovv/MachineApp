package machine.data.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import machine.data.entities.machines.Machine;

@Entity
@Table(name = "service_orders")
public class ServiceOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "machine_id", referencedColumnName = "id")
	private Machine machine;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	@ManyToMany
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

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
