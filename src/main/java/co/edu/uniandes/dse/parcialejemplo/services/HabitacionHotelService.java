package co.edu.uniandes.dse.parcialejemplo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionesEntity;
import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionesRepository;
import co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase que implementa la conexion con la persistencia para la relación entre
 * la entidad de Author y Book.
 *
 * @author ISIS2603
 */

@Slf4j
@Service
public class HabitacionHotelService {

	@Autowired
	private HabitacionesRepository habitacionRepository;

	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 * Asocia un Book existente a un Author
	 *
	 * @param authorId Identificador de la instancia de Author
	 * @param bookId   Identificador de la instancia de Book
	 * @return Instancia de BookEntity que fue asociada a Author
	 */

	@Transactional
	public HotelEntity addHabitaciones(Long hotelId, Long habitacionesId) throws EntityNotFoundException {
		log.info("Inicia proceso de asociarle una habitacion al hotel con id = {0}", hotelId);
		Optional<HotelEntity> hotelEntity = hotelRepository.findById(hotelId);
		Optional<HabitacionesEntity> habitacionEntity = habitacionRepository.findById(habitacionesId);

		if (hotelEntity.isEmpty())
			throw new EntityNotFoundException("Hotel not found");

		if (habitacionEntity.isEmpty())
			throw new EntityNotFoundException("habitacion not found");

		hotelEntity.get().getHabitacioness().add(habitacionEntity.get());
		log.info("Termina proceso de asociarle una habitacion al hotel con id = {0}", hotelId);
		return hotelEntity.get();
	}
}