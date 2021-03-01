package takmicenjaApp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import takmicenjaApp.model.Takmicenje;
import takmicenjaApp.repository.TakmicenjeRepository;
import takmicenjaApp.service.TakmicenjeService;

@Service
public class JpaTakmicenjeService implements TakmicenjeService{
	
	@Autowired
	private TakmicenjeRepository takmicenjeRepository;

	@Override
	public List<Takmicenje> findAll() {
		return takmicenjeRepository.findAll();
	}

	@Override
	public Takmicenje findOne(Long id) {
		return takmicenjeRepository.findOneById(id);
	}

	@Override
	public List<Takmicenje> find(List<Long> ids) {
		return takmicenjeRepository.findByIdIn(ids);
	}

	@Override
	public Page<Takmicenje> findAll(int brojStranice) {
		return takmicenjeRepository.findAll(PageRequest.of(brojStranice,10));
	}

	@Override
	public Takmicenje save(Takmicenje takmicenje) {
		return takmicenjeRepository.save(takmicenje);
	}

	@Override
	public Takmicenje update(Takmicenje takmicenje) {
		return takmicenjeRepository.save(takmicenje);
	}

	@Override
	public Takmicenje delete(Long id) {
		Optional<Takmicenje> takmicenje = takmicenjeRepository.findById(id);
		if(takmicenje.isPresent()) {
			takmicenjeRepository.deleteById(id);
			return takmicenje.get();
		}
		return null;
	}

	@Override
	public Page<Takmicenje> pretraga(String mestoOdrzavanja, Long formatId, int pageNo) {
		return takmicenjeRepository.pretraga(mestoOdrzavanja, formatId, PageRequest.of(pageNo, 2));
	}

}
