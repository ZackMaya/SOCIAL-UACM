package social.edu.uacm.service;

import java.util.List;

import social.edu.uacm.domain.Alumno;


public interface PeticionService {

	void recibirPeticion(Alumno alumno);
	List<Alumno> obtenerAlumno();
}
