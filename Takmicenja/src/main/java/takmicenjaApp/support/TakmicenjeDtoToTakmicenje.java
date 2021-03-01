package takmicenjaApp.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import takmicenjaApp.dto.TakmicenjeDTO;
import takmicenjaApp.model.Takmicenje;
import takmicenjaApp.service.FormatService;
import takmicenjaApp.service.TakmicenjeService;

@Component
public class TakmicenjeDtoToTakmicenje implements Converter<TakmicenjeDTO, Takmicenje>{
	
	@Autowired
	private TakmicenjeService takmicenjeService;
	
	@Autowired
	private FormatService formatService;

	@Override
	public Takmicenje convert(TakmicenjeDTO source) {
		Takmicenje takmicenje;
		
		if (source.getId() == null) {
			takmicenje = new Takmicenje();
		} else {
			takmicenje = takmicenjeService.findOne(source.getId());
		}
		
		if (takmicenje != null) {
			takmicenje.setDatumPocetka(source.getDatumPocetka());
			takmicenje.setDatumZavrsetka(source.getDatumZavrsetka());
			takmicenje.setMestoOdrzavanja(source.getMestoOdrzavanja());
			takmicenje.setNaziv(source.getNaziv());
			if (source.getFormat() != null) {
				takmicenje.setFormat(formatService.findOne(source.getFormat().getId()));
			}
		}
		return takmicenje;
	}
	
	

}
