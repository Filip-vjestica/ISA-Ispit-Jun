package kolokvijum.app.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import kolokvijum.app.DTO.UserDTO;

@Entity
public class User implements NapraviDTO<Long>,Identitet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private Set<UserRole> userRole;
	
	@OneToMany(mappedBy="korisnik")
	private List<Porudzbina> porudzbina;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(Long id, String username, String password, Set<UserRole> userRole, List<Porudzbina> porudzbina) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userRole = userRole;
		this.porudzbina = porudzbina;
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

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}



	public List<Porudzbina> getPorudzbina() {
		return porudzbina;
	}



	public void setPorudzbina(List<Porudzbina> porudzbina) {
		this.porudzbina = porudzbina;
	}
	
	@Override
	public UserDTO getDTO(boolean isInsideDTO) {
		UserDTO userDTO = new UserDTO(this, isInsideDTO);
		return userDTO;
	}
	
	
}

