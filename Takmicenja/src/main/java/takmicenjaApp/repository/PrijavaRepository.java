package takmicenjaApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import takmicenjaApp.model.Prijava;

@Repository
public interface PrijavaRepository extends JpaRepository<Prijava, Long>{
	
	Prijava findOneById(Long id);

	List<Prijava> findByIdIn(List<Long> ids);

}
