package machine.data.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
	@NotBlank
	private String username;
	@Basic
	@NotBlank
	private String password;

	@OneToMany(mappedBy= "user",cascade = CascadeType.PERSIST)
	private List<ServiceOrder> userOrders;


	public User() {
		super();
		this.userOrders = new ArrayList<>();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<ServiceOrder> getUserOrders() {
		return userOrders;
	}
	public void setUserOrders(List<ServiceOrder> userOrders) {
		this.userOrders = userOrders;
	}


}
