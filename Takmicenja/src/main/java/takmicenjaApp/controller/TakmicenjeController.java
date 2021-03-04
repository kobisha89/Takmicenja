package takmicenjaApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import takmicenjaApp.dto.TakmicenjeDTO;
import takmicenjaApp.model.Takmicenje;
import takmicenjaApp.service.TakmicenjeService;
import takmicenjaApp.support.TakmicenjeDtoToTakmicenje;
import takmicenjaApp.support.TakmicenjeToTakmicenjeDto;

@RestController
@RequestMapping(value = "/api/takmicenje", produces = MediaType.APPLICATION_JSON_VALUE)
public class TakmicenjeController {
	
	@Autowired
	private TakmicenjeService takmicenjeService;
	
	@Autowired
	private TakmicenjeToTakmicenjeDto toTakmicenjeDto;
	
	@Autowired
	private TakmicenjeDtoToTakmicenje toTakmicenje;
	
	@GetMapping
	public ResponseEntity<List<TakmicenjeDTO>> getAll(@RequestParam(required=false) String mestoOdrzavanja,
			@RequestParam(required=false) Long formatId,
			@RequestParam(defaultValue="0") int pageNo) {
		
		 	Page<Takmicenje> zadaciTakmicenje = takmicenjeService.pretraga(mestoOdrzavanja, formatId, pageNo);
	        
	        HttpHeaders responseHeaders = new HttpHeaders();
	        responseHeaders.set("Total-Pages", zadaciTakmicenje.getTotalPages() + "");
	        
	        return new ResponseEntity<>(toTakmicenjeDto.convert(zadaciTakmicenje.getContent()), responseHeaders, HttpStatus.OK);
	
	}
	
//	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity <TakmicenjeDTO> get(@PathVariable Long id) {
		Takmicenje takmicenje = takmicenjeService.findOne(id);
		
		if(takmicenje != null) {
            return new ResponseEntity<>(toTakmicenjeDto.convert(takmicenje), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <TakmicenjeDTO> create (@Valid @RequestBody TakmicenjeDTO takmicenjeDTO) {
		Takmicenje takmicenje = toTakmicenje.convert(takmicenjeDTO);
		Takmicenje sacuvanTakmicenje = takmicenjeService.save(takmicenje);
		
		return new ResponseEntity<>(toTakmicenjeDto.convert(sacuvanTakmicenje), HttpStatus.CREATED);
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TakmicenjeDTO> update(@PathVariable Long id, @Valid @RequestBody TakmicenjeDTO takmicenjeDTO){

        if(!id.equals(takmicenjeDTO.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    	Takmicenje takmicenje = toTakmicenje.convert(takmicenjeDTO);
		Takmicenje sacuvanTakmicenje = takmicenjeService.save(takmicenje);

        return new ResponseEntity<>(toTakmicenjeDto.convert(sacuvanTakmicenje),HttpStatus.OK);
    }
	
//	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
		Takmicenje obrisanTakmicenje = takmicenjeService.delete(id);

        if(obrisanTakmicenje != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	

}
