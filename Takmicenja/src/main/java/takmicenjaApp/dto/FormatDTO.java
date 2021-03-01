package takmicenjaApp.dto;

import javax.validation.constraints.Positive;

public class FormatDTO {
	
	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	private String tip;
	
	private int brojUcesnika;

	@Override
	public String toString() {
		return "FormatDTO []";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getBrojUcesnika() {
		return brojUcesnika;
	}

	public void setBrojUcesnika(int brojUcesnika) {
		this.brojUcesnika = brojUcesnika;
	}
	
	

}
