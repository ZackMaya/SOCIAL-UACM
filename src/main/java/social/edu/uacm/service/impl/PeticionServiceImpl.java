package social.edu.uacm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import social.edu.uacm.domain.Alumno;
import social.edu.uacm.service.PeticionService;

@Service
public class PeticionServiceImpl implements PeticionService{
private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public void recibirPeticion(Alumno alumno) {
		log.debug("Entre a recibirPeticion(Alumno alumno)");
		log.debug(alumno.toString());
	}

	@Override
	public List<Alumno> obtenerAlumno() {
		// TODO Auto-generated method stub
		return null;
	}

	/*public List<Alumno> obtenerAlumno() {
		
		List<Alumno> alumnos=new ArrayList<Alumno>();
		
		for(int i=0; i<10; i++){
			Alumno alumno=new Alumno();
			alumno.setEmail("netozack@hotmail.com");
			alumno.setContrasena("1234");
			alumnos.add(alumno);
		}
		
		return alumnos;
	}*/
}
