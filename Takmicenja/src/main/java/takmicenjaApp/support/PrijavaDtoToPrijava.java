package takmicenjaApp.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import takmicenjaApp.dto.PrijavaDTO;
import takmicenjaApp.model.Prijava;
import takmicenjaApp.service.PrijavaService;
import takmicenjaApp.service.TakmicenjeService;

@Component
public class PrijavaDtoToPrijava implements Converter<PrijavaDTO, Prijava>{
	
	@Autowired
	private PrijavaService prijavaService;
	
	@Autowired
	private TakmicenjeService takmicenjeService;

	@Override
	public Prijava convert(PrijavaDTO source) {
		Prijava prijava;
		
		if (source.getId() == null) {
			prijava = new Prijava();
		} else {
			prijava = prijavaService.findOne(source.getId());
		}
		
		if (prijava != null) {
			prijava.setDatumPrijave(source.getDatumPrijave());
			prijava.setDrzavaTakmicara(source.getDrzavaTakmicara());
			prijava.setKontakt(source.getKontakt());
			
			if (source.getTakmicenje() != null) {
				prijava.setTakmicenje(takmicenjeService.findOne(source.getTakmicenje().getId()));
			}
		}
		return null;
	}

}
