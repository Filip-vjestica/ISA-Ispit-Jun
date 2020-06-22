package kolokvijum.app.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import kolokvijum.app.DTO.StavkaPorudzbineDTO;

@Entity
public class StavkaPorudzbine implements NapraviDTO<Long>, Identitet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String naziv;
	
	private Double cena;
	
	@ManyToOne
	private Porudzbina porudzbina;

	public StavkaPorudzbine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StavkaPorudzbine(Long id, String naziv, Double cena, Porudzbina porudzbina) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.porudzbina = porudzbina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public Porudzbina getPorudzbina() {
		return porudzbina;
	}

	public void setPorudzbina(Porudzbina porudzbina) {
		this.porudzbina = porudzbina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StavkaPorudzbine other = (StavkaPorudzbine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public StavkaPorudzbineDTO getDTO(boolean isInsideDTO) {
		StavkaPorudzbineDTO stavkaPorudzbineDTO = new StavkaPorudzbineDTO(this, isInsideDTO);
		return stavkaPorudzbineDTO;
	}
	
	
}
