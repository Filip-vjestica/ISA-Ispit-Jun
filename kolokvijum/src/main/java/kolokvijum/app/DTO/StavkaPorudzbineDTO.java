package kolokvijum.app.DTO;

import kolokvijum.app.model.StavkaPorudzbine;

public class StavkaPorudzbineDTO implements DTO {
	

	private static final long serialVersionUID = 1L;
	private Long id;
	private String naziv;
	private Double cena;
	private PorudzbinaDTO porudzbina;
	
	public StavkaPorudzbineDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StavkaPorudzbineDTO(Long id, String naziv, Double cena, PorudzbinaDTO porudzbina) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.porudzbina = porudzbina;
	}
	
	public StavkaPorudzbineDTO(StavkaPorudzbine stavkaPorudzbine,boolean isInsideDTO) {
		this.id = stavkaPorudzbine.getId();
		this.naziv = stavkaPorudzbine.getNaziv();
		this.cena = stavkaPorudzbine.getCena();
		
		if(!isInsideDTO) {
			this.porudzbina = stavkaPorudzbine.getPorudzbina().getDTO(!isInsideDTO);
		}
		
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

	public PorudzbinaDTO getPorudzbina() {
		return porudzbina;
	}

	public void setPorudzbina(PorudzbinaDTO porudzbina) {
		this.porudzbina = porudzbina;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
