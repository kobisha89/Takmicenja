package takmicenjaApp.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import takmicenjaApp.dto.FormatDTO;
import takmicenjaApp.model.Format;

@Component
public class FormatToFormatDto implements Converter<Format, FormatDTO>{

	@Override
	public FormatDTO convert(Format source) {
		FormatDTO formatDTO = new FormatDTO();
		
		formatDTO.setId(source.getId());
		formatDTO.setBrojUcesnika(source.getBrojUcesnika());
		formatDTO.setTip(source.getTip());
		return formatDTO;
	}
	
	public List<FormatDTO> convert(List<Format> formati) {
		List<FormatDTO> formatiDTO = new ArrayList<>();
		
		for (Format l: formati) {
			formatiDTO.add(convert(l));
		}
		
		return formatiDTO;
	}

}
