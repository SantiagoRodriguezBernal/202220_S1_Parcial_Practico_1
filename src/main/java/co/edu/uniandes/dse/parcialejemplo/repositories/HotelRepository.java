package co.edu.uniandes.dse.parcialejemplo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;



/**
 * Interface that persists an editorial
 *
 * @author ISIS2603
 *
 */
@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
	List<HotelEntity> findById(long id );

    String findByNombre(String nombre);
}