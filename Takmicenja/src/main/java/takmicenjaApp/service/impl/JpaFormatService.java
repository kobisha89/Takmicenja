package takmicenjaApp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import takmicenjaApp.model.Format;
import takmicenjaApp.repository.FormatRepository;
import takmicenjaApp.service.FormatService;

@Service
public class JpaFormatService implements FormatService{
	
	@Autowired
	private FormatRepository formatRepository;

	@Override
	public List<Format> findAll() {
		return formatRepository.findAll();
	}

	@Override
	public Format findOne(Long id) {
		return formatRepository.findOneById(id);
	}

	@Override
	public List<Format> find(List<Long> ids) {
		return formatRepository.findByIdIn(ids);
	}

	@Override
	public Page<Format> findAll(int brojStranice) {
		return formatRepository.findAll(PageRequest.of(brojStranice,10));
	}

	@Override
	public Format save(Format format) {
		return formatRepository.save(format);
	}

	@Override
	public Format update(Format format) {
		return formatRepository.save(format);
	}

	@Override
	public Format delete(Long id) {
		Optional<Format> format = formatRepository.findById(id);
		if(format.isPresent()) {
			formatRepository.deleteById(id);
			return format.get();
		}
		return null;
	}

}
