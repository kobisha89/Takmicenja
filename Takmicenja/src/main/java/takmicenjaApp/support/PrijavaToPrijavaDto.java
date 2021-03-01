package takmicenjaApp.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import takmicenjaApp.dto.PrijavaDTO;
import takmicenjaApp.model.Prijava;

@Component
public class PrijavaToPrijavaDto implements Converter<Prijava, PrijavaDTO>{
	
	private TakmicenjeToTakmicenjeDto toTakmicenjeDto;

	@Override
	public PrijavaDTO convert(Prijava source) {
		PrijavaDTO prijavaDTO = new PrijavaDTO();
		
		prijavaDTO.setId(source.getId());
		prijavaDTO.setKontakt(source.getKontakt());
		prijavaDTO.setDrzavaTakmicara(source.getDrzavaTakmicara());
		prijavaDTO.setDatumPrijave(source.getDatumPrijave());
		prijavaDTO.setTakmicenje(toTakmicenjeDto.convert(source.getTakmicenje()));
		
		return prijavaDTO;
	}
	
	public List<PrijavaDTO> convert(List<Prijava> prijave) {
		List<PrijavaDTO> prijaveDTO = new ArrayList<>();
		
		for (Prijava l: prijave) {
			prijaveDTO.add(convert(l));
		}
		
		return prijaveDTO;
	}

}
