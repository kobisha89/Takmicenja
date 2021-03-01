package takmicenjaApp.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import takmicenjaApp.dto.PrijavaDTO;
import takmicenjaApp.model.Prijava;
import takmicenjaApp.model.Takmicenje;
import takmicenjaApp.service.PrijavaService;
import takmicenjaApp.service.TakmicenjeService;
import takmicenjaApp.support.PrijavaDtoToPrijava;
import takmicenjaApp.support.PrijavaToPrijavaDto;

@RestController
@RequestMapping(value = "/api/prijave", produces = MediaType.APPLICATION_JSON_VALUE)
public class PrijavaController {
	

	
	@Autowired
	private TakmicenjeService takmicenjeService;
	
	@Autowired
	private PrijavaService prijavaService;
	
	@Autowired
	private PrijavaDtoToPrijava toPrijava;
	
	@Autowired
	private PrijavaToPrijavaDto toPrijavaDto;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <PrijavaDTO> create (@Valid @RequestBody PrijavaDTO prijavaDTO) {
		Prijava prijava = toPrijava.convert(prijavaDTO);
		Prijava sacuvanPrijava = prijavaService.save(prijava);
		
		return new ResponseEntity<>(toPrijavaDto.convert(sacuvanPrijava), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<PrijavaDTO> prijava(@RequestParam(required=false) Long id,
			@RequestParam(required=false) String drzavaTakmicara, 
			@RequestParam(required=false) String kontakt) {
		
		LocalDateTime now = LocalDateTime.now();
		String datum = now.toString();
		
		Takmicenje takmicenje = takmicenjeService.findOne(id);
		Prijava prijava = new Prijava();
		
		
		
		if (takmicenje.getFormat().getBrojUcesnika() > 0) {
			prijava.setDrzavaTakmicara(drzavaTakmicara);
			prijava.setKontakt(kontakt);
			prijava.setDatumPrijave(datum);
			prijava.setTakmicenje(takmicenje);
			
			prijavaService.save(prijava);
			takmicenje.getFormat().setBrojUcesnika(takmicenje.getFormat().getBrojUcesnika() - 1);
			takmicenjeService.save(takmicenje);
			
			
			return new ResponseEntity<>(toPrijavaDto.convert(prijava), HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
