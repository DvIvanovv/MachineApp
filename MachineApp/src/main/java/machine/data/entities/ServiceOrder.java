package machine.data.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "service_orders")
public class ServiceOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "machinearanty_id", referencedColumnName = "id")
	private Waranty waranty;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "service_order_accessories")
	List<Accessory> accsesories ;
	@Column(name = "service_date")
	private Date serviceDate;



	public ServiceOrder() {
		super();
		this.accsesories = new ArrayList<>();
	}

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



	public Waranty getWaranty() {
		return waranty;
	}

	public void setWaranty(Waranty waranty) {
		this.waranty = waranty;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}


}
