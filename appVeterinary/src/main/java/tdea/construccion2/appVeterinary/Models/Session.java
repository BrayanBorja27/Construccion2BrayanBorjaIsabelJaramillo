package tdea.construccion2.appVeterinary.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import tdea.construccion2.appVeterinary.Dto.SessionDto;

@Entity
@Table(name = "sesion")
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "username")
	private String userName;
	@Column(name = "role")
	private String rol;

	public Session(SessionDto sessionDto) {
		this.id = sessionDto.getId();
		this.userName = sessionDto.getUserName();
		this.rol = sessionDto.getRole();
	}

	public Session() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
