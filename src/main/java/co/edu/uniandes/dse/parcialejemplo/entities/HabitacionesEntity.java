package co.edu.uniandes.dse.parcialejemplo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;




@Getter
@Setter
@Entity
public class HabitacionesEntity extends BaseEntity {
	
	private Long identificacion;
	private int  personas ;
	private int camas;
    private int baños;
    private long id;



	@PodamExclude
	@ManyToOne
	private HotelEntity hotel;

	
}