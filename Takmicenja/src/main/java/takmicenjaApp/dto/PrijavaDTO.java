package takmicenjaApp.dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PrijavaDTO {
	
	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	@Size(min=1, max=3)
	private String drzavaTakmicara;
	
	private String kontakt;
	
	private String datumPrijave;
	
	private TakmicenjeDTO takmicenje;

	public PrijavaDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDrzavaTakmicara() {
		return drzavaTakmicara;
	}

	public void setDrzavaTakmicara(String drzavaTakmicara) {
		this.drzavaTakmicara = drzavaTakmicara;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public String getDatumPrijave() {
		return datumPrijave;
	}

	public void setDatumPrijave(String datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public TakmicenjeDTO getTakmicenje() {
		return takmicenje;
	}

	public void setTakmicenje(TakmicenjeDTO takmicenje) {
		this.takmicenje = takmicenje;
	}
	
	

}
