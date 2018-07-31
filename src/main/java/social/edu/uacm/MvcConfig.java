package social.edu.uacm;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/sesion.html").setViewName("sesion");
		registry.addViewController("/").setViewName("sesion");
		registry.addViewController("/registro.html").setViewName("registro");
		registry.addViewController("/index.html").setViewName("index");
		registry.addViewController("/eventos.html").setViewName("eventos");
		registry.addViewController("/ingenieria.html").setViewName("ingenieria");
		registry.addViewController("/certificaciones.html").setViewName("certificaciones");
		
	}
}
