package machine.data.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "service_orders")
public class ServiceOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "machineWarranty_id", referencedColumnName = "id")
	private Warranty warranty;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "service_order_accessories")
	List<Consumable> accessories ;
	@Column(name = "service_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date serviceDate;



	public ServiceOrder() {
		super();
		this.accessories = new ArrayList<>();
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
	public List<Consumable> getAccsesories() {
		return accessories;
	}
	/**
	 * @param accsesories the accsesories to set
	 */
	public void setAccsesories(List<Consumable> accsesories) {
		this.accessories = accsesories;
	}



	public Warranty getWarranty() {
		return warranty;
	}

	public void setWarranty(Warranty waranty) {
		this.warranty = waranty;
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
