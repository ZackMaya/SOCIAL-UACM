package social.edu.uacm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import social.edu.uacm.domain.Alumno;
import social.edu.uacm.service.PeticionService;



@Controller 
@RequestMapping("/peticion")
public class PeticionController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PeticionService peticionService;
	
	/* Los metodos POST NO se ven en la url
	 * el metodo GET si se ve en la url
	 */	
	@RequestMapping(value="/sesion", method=RequestMethod.POST)
	public String redireccionar(){
		log.debug("--------Estoy entrando a inicio");
		Alumno alumno= new Alumno();
		alumno.setEmail("netozack@gmail.com");
		alumno.setContrasena("root");
		
		peticionService.recibirPeticion(alumno);
		return "redirect:/index.html"; //y lo que hace redirecciona a otra pagina
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String recibirParametros(@ModelAttribute Alumno alumno){
		log.debug("entrando a recibir parametros");
		log.debug("el valor del alumno es: " + alumno.toString());
		
		return "redirect:/index.html?ok = true";
	}
}
