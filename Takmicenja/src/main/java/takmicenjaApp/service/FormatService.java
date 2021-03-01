package takmicenjaApp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import takmicenjaApp.model.Format;

public interface FormatService {
	
	List<Format> findAll();
	
	Format findOne(Long id);
	
	List<Format> find(List<Long> ids);
	
	Page<Format> findAll(int brojStranice);
	
	Format save (Format format);
	
	Format update (Format format);
	
	Format delete (Long id);

}
