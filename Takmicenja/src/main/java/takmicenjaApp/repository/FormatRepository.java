package takmicenjaApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import takmicenjaApp.model.Format;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long>{
	
	Format findOneById(Long id);

	List<Format> findByIdIn(List<Long> ids);

}
