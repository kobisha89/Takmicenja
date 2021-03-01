package takmicenjaApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import takmicenjaApp.dto.FormatDTO;
import takmicenjaApp.model.Format;
import takmicenjaApp.service.FormatService;
import takmicenjaApp.support.FormatToFormatDto;

@RestController
@RequestMapping(value = "/api/formati", produces = MediaType.APPLICATION_JSON_VALUE)
public class FormatController {
	
	@Autowired
	private FormatService formatService;
	
	@Autowired
	private FormatToFormatDto toFormatDto;
	
//	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@GetMapping
	public ResponseEntity<List<FormatDTO>> getAll () {
		
		List<Format> formati = formatService.findAll();
		
		return new ResponseEntity<>(toFormatDto.convert(formati), HttpStatus.OK);
	}

}
