package social.edu.uacm.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import social.edu.uacm.dao.AlumnoDao;
import social.edu.uacm.domain.Alumno;


@Repository
public class AlumnoDaoImpl implements AlumnoDao {
private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	//inyecta la conexion al jdbc en application.properties
	@Override
	public Alumno obtenerAlumnoPorId(Integer Id) {
		String query="SELECT id, nombre from alumno where id="+Id;
		try{
		log.debug(query);
		return jdbcTemplate.queryForObject(query, new RowMapper<Alumno>() {
			//funcion anonima
			@Override
			public Alumno mapRow(ResultSet rs, int rowNum) throws SQLException {
				Alumno alumno=new Alumno();
				alumno.setId(Id);
				//lo que me regresa rs en get se lo asigno a vehiculo con el metodo set
				alumno.setNombre(rs.getString(2));
				return alumno;
			}
		});
		}catch(EmptyResultDataAccessException dataException){
			return null;
		}catch(BadSqlGrammarException sqlException){
			//por que es modelo no model error en escribir la orden
			//podemos mandar mensajes de errores
			return null;
		}
	}
	
}
