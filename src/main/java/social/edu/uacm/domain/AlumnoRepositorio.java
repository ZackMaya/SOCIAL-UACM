package social.edu.uacm.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AlumnoRepositorio {
	private JdbcTemplate jdbc;

	@Autowired
	public AlumnoRepositorio(JdbcTemplate jdbc){
		this.jdbc=jdbc;
		
	}
}
