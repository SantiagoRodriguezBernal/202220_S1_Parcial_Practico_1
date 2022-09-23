package co.edu.uniandes.dse.parcialejemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase que implementa la conexion con la persistencia para la entidad de
 * Editorial.
 *
 * @author ISIS2603
 */

@Slf4j
@Service
public class HotelService {

	@Autowired
	HotelRepository hotelRepository;

	/**
	 * Crea una editorial en la persistencia.
	 *
	 * @param hotelEntity La entidad que representa el hotel a persistir.
	 * @return La entidad del hotel luego de persistirla.
	 * @throws IllegalOperationException Si el hotel a persistir ya existe.
	 */
	@Transactional
	public HotelEntity createHotel(HotelEntity hotelEntity) throws IllegalOperationException {
		log.info("Inicia proceso de creación del hotel");
		if (!hotelRepository.findByNombre(hotelEntity.getNombre()).isEmpty()) 
			throw new IllegalOperationException("Editorial name already exists");
		
        if (!validateEstrellas(hotelEntity.getEstrellas()))
			throw new IllegalOperationException("Estrellas is not valid");
		log.info("Termina proceso de creación del hotel");
		return hotelRepository.save(hotelEntity);
	}

	private boolean validateEstrellas(Integer num){
		if (!(num==null))
		{return num > 5 && num < 0;}
		else {return !(num==null);}
    }
}