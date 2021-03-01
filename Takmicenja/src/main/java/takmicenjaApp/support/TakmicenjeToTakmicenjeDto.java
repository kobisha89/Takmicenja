package takmicenjaApp.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import takmicenjaApp.dto.TakmicenjeDTO;
import takmicenjaApp.model.Takmicenje;

@Component
public class TakmicenjeToTakmicenjeDto implements Converter<Takmicenje, TakmicenjeDTO>{
	
	@Autowired
	private FormatToFormatDto tFormatDto;

	@Override
	public TakmicenjeDTO convert(Takmicenje source) {
		TakmicenjeDTO takmicenjeDTO = new TakmicenjeDTO();
		
		takmicenjeDTO.setId(source.getId());
		takmicenjeDTO.setMestoOdrzavanja(source.getMestoOdrzavanja());
		takmicenjeDTO.setDatumPocetka(source.getDatumPocetka());
		takmicenjeDTO.setDatumZavrsetka(source.getDatumZavrsetka());
		takmicenjeDTO.setNaziv(source.getNaziv());
		takmicenjeDTO.setFormat(tFormatDto.convert(source.getFormat()));
		
		return takmicenjeDTO;
	}
	
	public List<TakmicenjeDTO> convert(List<Takmicenje> takmicenje) {
		List<TakmicenjeDTO> takmicenjeDTO = new ArrayList<>();
		
		for (Takmicenje l: takmicenje) {
			takmicenjeDTO.add(convert(l));
		}
		
		return takmicenjeDTO;
	}

}
