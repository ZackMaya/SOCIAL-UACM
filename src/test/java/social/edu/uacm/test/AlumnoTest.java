package social.edu.uacm.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import social.edu.uacm.Application;
import social.edu.uacm.domain.Alumno;
import social.edu.uacm.domain.AlumnoRepository;
import social.edu.uacm.domain.Documento;
import social.edu.uacm.domain.DocumentoRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class AlumnoTest {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	//inyecta los objetos
		@Autowired
		AlumnoRepository alumnoRepository;
		@Autowired
		DocumentoRepository documentoRepository;
				
		@Test
		public void test() {
			Alumno alumno = new Alumno();
			alumno.setNombre("Fernanda");
			alumno.setEmail("muziek@hotmail.com");
			alumno.setNombreusuario("muziek");
			alumno.setPlantel(1);
			alumno.setTelefono("54435345");
			alumno.setWeb("www.alla.com.mx");
			alumno.setContrasena("1234");
			
			alumnoRepository.save(alumno);
			
			Documento documento = new Documento();
			documento.setNombreproyecto("Metricas");
			documento.setMateria("Metricas de software");
			documento.setTecnologia("Spring");
			documento.setAlumno(alumno);
			documentoRepository.save(documento);
		}
}
