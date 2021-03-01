package takmicenjaApp.dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TakmicenjeDTO {
	
	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	private String naziv;
	
	@Size(max=50)
	private String mestoOdrzavanja;
	
	private String datumPocetka;
	
	private String datumZavrsetka;
	
	private FormatDTO format;

	public TakmicenjeDTO() {
		super();
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

	public String getMestoOdrzavanja() {
		return mestoOdrzavanja;
	}

	public void setMestoOdrzavanja(String mestoOdrzavanja) {
		this.mestoOdrzavanja = mestoOdrzavanja;
	}

	public String getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(String datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public String getDatumZavrsetka() {
		return datumZavrsetka;
	}

	public void setDatumZavrsetka(String datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}

	public FormatDTO getFormat() {
		return format;
	}

	public void setFormat(FormatDTO format) {
		this.format = format;
	}
	
	

}
