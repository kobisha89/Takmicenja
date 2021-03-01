package takmicenjaApp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import takmicenjaApp.model.Prijava;

public interface PrijavaService {
	
	List<Prijava> findAll();
	
	Prijava findOne(Long id);
	
	List<Prijava> find(List<Long> ids);
	
	Page<Prijava> findAll(int brojStranice);
	
	Prijava save (Prijava prijava);
	
	Prijava update (Prijava prijava);
	
	Prijava delete (Long id);

}
