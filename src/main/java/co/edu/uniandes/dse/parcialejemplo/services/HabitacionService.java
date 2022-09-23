package co.edu.uniandes.dse.parcialejemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionesEntity;
import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;
import co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionesRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase que implementa la conexion con la persistencia para la entidad de
 * Editorial.
 *
 * @author ISIS2603
 */

@Slf4j
@Service
public class HabitacionService {

	@Autowired
	HotelRepository hotelRepository;

    @Autowired
	HabitacionesRepository habitacionRepository;

	/**
	 * Crea una editorial en la persistencia.
	 *
	 * @param habitacionesEntity La entidad que representa el hotel a persistir.
	 * @return La entidad de la habitacion luego de persistirla.
	 * @throws IllegalOperationException Si el hotel a persistir ya existe.
	 */
	@Transactional
	public HabitacionesEntity createHabitacion(HabitacionesEntity habitacionesEntity) throws IllegalOperationException {
		log.info("Inicia proceso de creación de una habitacion");
		if (habitacionesEntity.getHotel() == null)
		throw new IllegalOperationException("Hotel is not valid");
	
	List<HotelEntity> hotelEntity = hotelRepository.findById(habitacionesEntity.getHotel().getId());
	if (hotelEntity.isEmpty())
		throw new IllegalOperationException("Editorial is not valid");
   
		log.info("Termina proceso de creación del hotel");
		return habitacionRepository.save(habitacionesEntity);
	}


}