package machine.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "auth_user_group_name")
public class AuthGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
	private String username;
	@Column(name = "auth_group")
	private String authGroup;
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
	 * @return the userName
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the authGroup
	 */
	public String getAuthGroup() {
		return authGroup;
	}
	/**
	 * @param authGroup the authGroup to set
	 */
	public void setAuthGroup(String authGroup) {
		this.authGroup = authGroup;
	}
	
	

}
