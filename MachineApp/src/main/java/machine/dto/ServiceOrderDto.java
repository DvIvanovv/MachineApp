package machine.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import machine.data.entities.Consumable;
import machine.data.entities.User;
import machine.data.entities.Warranty;

public class ServiceOrderDto {

	private Long id;
	@NotNull
	private String forMachine;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date serviceDate;
	private User user;
	private Warranty warranty;
	private List<String> consumables;
							
	public ServiceOrderDto() {
		super();
		this.consumables = new ArrayList<>();
	}
	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Warranty getWarranty() {
		return warranty;
	}


	public void setWarranty(Warranty warranty) {
		this.warranty = warranty;
	}


	public List<String> getConsumables() {
		return consumables;
	}


	public void setConsumables(List<String> consumables) {
		this.consumables = consumables;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getForMachine() {
		return forMachine;
	}

	public void setForMachine(String forMachine) {
		this.forMachine = forMachine;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

}
