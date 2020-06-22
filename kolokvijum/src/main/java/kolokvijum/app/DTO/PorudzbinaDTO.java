package kolokvijum.app.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import kolokvijum.app.model.Porudzbina;

public class PorudzbinaDTO implements DTO {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String brojPorudzbine;
	private Long restoran;
	private LocalDateTime datumPorudzbine;
	private String status;
	private UserDTO korisnik;
	private List<StavkaPorudzbineDTO> stavkaPorudzbine;
	
	public PorudzbinaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PorudzbinaDTO(Long id, String brojPorudzbine, Long restoran, LocalDateTime datumPorudzbine, String status,
			UserDTO korisnik, List<StavkaPorudzbineDTO> stavkaPorudzbine) {
		super();
		this.id = id;
		this.brojPorudzbine = brojPorudzbine;
		this.restoran = restoran;
		this.datumPorudzbine = datumPorudzbine;
		this.status = status;
		this.korisnik = korisnik;
		this.stavkaPorudzbine = stavkaPorudzbine;
	}
	
	public PorudzbinaDTO(Porudzbina porudzbina,boolean isInsideDTO) {
		this.id = porudzbina.getId();
		this.brojPorudzbine = porudzbina.getBrojPorudzbine();
		this.restoran = porudzbina.getRestoran();
		this.datumPorudzbine = porudzbina.getDatumPorudzbine();
		this.status = porudzbina.getStatus();
		
		if(!isInsideDTO) {
			this.korisnik = porudzbina.getKorisnik().getDTO(!isInsideDTO);
			this.stavkaPorudzbine = porudzbina.getStavkaPorudzbine().stream().map(p -> p.getDTO(!isInsideDTO)).collect(Collectors.toList());
		}
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrojPorudzbine() {
		return brojPorudzbine;
	}

	public void setBrojPorudzbine(String brojPorudzbine) {
		this.brojPorudzbine = brojPorudzbine;
	}

	public Long getRestoran() {
		return restoran;
	}

	public void setRestoran(Long restoran) {
		this.restoran = restoran;
	}

	public LocalDateTime getDatumPorudzbine() {
		return datumPorudzbine;
	}

	public void setDatumPorudzbine(LocalDateTime datumPorudzbine) {
		this.datumPorudzbine = datumPorudzbine;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserDTO getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(UserDTO korisnik) {
		this.korisnik = korisnik;
	}

	public List<StavkaPorudzbineDTO> getStavkaPorudzbine() {
		return stavkaPorudzbine;
	}

	public void setStavkaPorudzbine(List<StavkaPorudzbineDTO> stavkaPorudzbine) {
		this.stavkaPorudzbine = stavkaPorudzbine;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
