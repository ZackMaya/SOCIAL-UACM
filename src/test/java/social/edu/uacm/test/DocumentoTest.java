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
import social.edu.uacm.domain.Documento;
import social.edu.uacm.domain.DocumentoRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class DocumentoTest {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	//inyecta los objetos
		@Autowired
		DocumentoRepository documentoRepository;
		
		
		@Test
		public void test() {
			Documento documento = new Documento();
			documento.setNombreproyecto("PruebasUnitarias");
			documento.setMateria("Pruebas");
			documento.setTecnologia("Spring");
		documentoRepository.save(documento);
		
		}
}
