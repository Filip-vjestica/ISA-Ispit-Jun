package kolokvijum.app.DTO;

import java.util.List;
import java.util.stream.Collectors;

import kolokvijum.app.model.User;

public class UserDTO implements DTO {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String password;
	
	private List<PorudzbinaDTO> porudzbina;
	
	
	
	public UserDTO(Long id, String username, String password, List<PorudzbinaDTO> porudzbina) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.porudzbina = porudzbina;
	}
	
	public UserDTO(User korisnik,boolean isInsideDTO) {
		this.id = korisnik.getId();
		this.username = korisnik.getUsername();
		this.password = korisnik.getPassword();
		if(!isInsideDTO) {
			this.porudzbina = korisnik.getPorudzbina().stream().map(v -> v.getDTO(!isInsideDTO)).collect(Collectors.toList());
		}
	}

	public UserDTO(String username) {
		super();
		this.username = username;
	}
	
	public UserDTO(User user) {
		this(user.getUsername());
	}
	public UserDTO() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PorudzbinaDTO> getPorudzbina() {
		return porudzbina;
	}

	public void setPorudzbina(List<PorudzbinaDTO> porudzbina) {
		this.porudzbina = porudzbina;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
