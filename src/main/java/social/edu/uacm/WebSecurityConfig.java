package social.edu.uacm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            	//Todos los html tienen permitido la seguridad 
                .antMatchers("/registro*").permitAll()
                .antMatchers("/sesion*").permitAll()
                .antMatchers("/index*").permitAll()
                .antMatchers("/eventos*").permitAll()
                .antMatchers("/ingenieria*").permitAll()
                .antMatchers("/certificaciones*").permitAll()
                //Recursos...al momento de habilitar la seguridad web
                //puede que no se carguen los siguientes "son carpetas de recursos"
                .antMatchers("/css/**").permitAll()
                .antMatchers("/imagenes/**").permitAll()
                .antMatchers("/imagenes/**/certificaciones/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/videos/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
            //Parte de seguridad
	            .loginPage("/sesion")//sesion.html
	            .loginProcessingUrl("/j_spring_security_check")//template , se puede poner "seguridad" nosotros lo definimos
	            .defaultSuccessUrl("/index.html")//cuando se hace el login "existe el usuario" 
	            .failureUrl("/login?error=true")//"error" prueba del login "mensaje de error"
	            .successHandler(myAuthenticationSuccessHandler)//Manejador de autentificacion
	            .usernameParameter("j_username")
	            .passwordParameter("j_password")
	        .permitAll()
	            .and()
	        .sessionManagement()
	            .invalidSessionUrl("/sesion.html")//"termina tiempo de login"
	            .sessionFixation().none()
	        .and()
	        .logout()
	            .invalidateHttpSession(false)
	            .logoutUrl("/j_spring_security_logout")//Cerrar sesion 
	            .logoutSuccessUrl("/login?logSucc=true")
	           .deleteCookies("JSESSIONID")//destruye el cookie con usuario y contrasenia
	            .permitAll();
    }
	
	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }
	
    
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

       registry.addResourceHandler("/public/**")
          .addResourceLocations("/public/", "classpath:/public/");
    }
    
    
    
    @Bean
    public DaoAuthenticationProvider authProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        return authProvider;
    }
}
