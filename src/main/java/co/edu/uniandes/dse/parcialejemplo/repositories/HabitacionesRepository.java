package co.edu.uniandes.dse.parcialejemplo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionesEntity;

/**
 * Interface that persists a book
 *
 * @author ISIS2603
 *
 */
@Repository
public interface HabitacionesRepository extends JpaRepository<HabitacionesEntity, Long> {
	List<HabitacionesEntity> findById(long id);
}
    
    

