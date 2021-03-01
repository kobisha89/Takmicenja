package takmicenjaApp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import takmicenjaApp.model.Takmicenje;

public interface TakmicenjeService {
	
	List<Takmicenje> findAll();
	
	Takmicenje findOne(Long id);
	
	List<Takmicenje> find(List<Long> ids);
	
	Page<Takmicenje> findAll(int brojStranice);
	
	Takmicenje save (Takmicenje takmicenje);
	
	Takmicenje update (Takmicenje takmicenje);
	
	Takmicenje delete (Long id);

	Page<Takmicenje> pretraga(String mestoOdrzavanja, Long formatId, int pageNo);

}
