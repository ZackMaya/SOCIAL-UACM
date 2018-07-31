package social.edu.uacm.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import social.edu.uacm.domain.Alumno;
import social.edu.uacm.domain.AlumnoRepository;
import social.edu.uacm.service.MyUserDetailsService;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	//Privilegios
	 private final List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
	        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        for (final String privilege : privileges) {
	            authorities.add(new SimpleGrantedAuthority(privilege));
	        }
	        return authorities;
	    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
