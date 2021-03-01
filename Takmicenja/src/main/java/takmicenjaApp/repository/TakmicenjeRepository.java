package takmicenjaApp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import takmicenjaApp.model.Takmicenje;

@Repository
public interface TakmicenjeRepository extends JpaRepository<Takmicenje, Long>{
	
	Takmicenje findOneById(Long id);

	List<Takmicenje> findByIdIn(List<Long> ids);
	
	@Query("SELECT p FROM Takmicenje p WHERE "
			+ "(:mestoOdrzavanja IS NULL OR p.mestoOdrzavanja like %:mestoOdrzavanja%) AND "
			+ "(:formatId IS NULL OR p.format.id = :formatId)")
	Page<Takmicenje> pretraga(@Param("mestoOdrzavanja")String mestoOdrzavanja , @Param("formatId") Long formatId, Pageable pageable);

}
