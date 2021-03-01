package takmicenjaApp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import takmicenjaApp.model.Prijava;
import takmicenjaApp.repository.PrijavaRepository;
import takmicenjaApp.service.PrijavaService;

@Service
public class JpaPrijavaService implements PrijavaService{
	
	@Autowired
	private PrijavaRepository prijavaRepository;

	@Override
	public List<Prijava> findAll() {
		return prijavaRepository.findAll();
	}

	@Override
	public Prijava findOne(Long id) {
		return prijavaRepository.findOneById(id);
	}

	@Override
	public List<Prijava> find(List<Long> ids) {
		return prijavaRepository.findByIdIn(ids);
	}

	@Override
	public Page<Prijava> findAll(int brojStranice) {
		return prijavaRepository.findAll(PageRequest.of(brojStranice,10));
	}

	@Override
	public Prijava save(Prijava prijava) {
		return prijavaRepository.save(prijava);
	}

	@Override
	public Prijava update(Prijava prijava) {
		return prijavaRepository.save(prijava);
	}

	@Override
	public Prijava delete(Long id) {
		Optional<Prijava> prijava = prijavaRepository.findById(id);
		if(prijava.isPresent()) {
			prijavaRepository.deleteById(id);
			return prijava.get();
		}
		return null;
	}

}
