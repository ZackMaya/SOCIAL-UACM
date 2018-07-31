package social.edu.uacm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Documentos")
public class Documento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer iddocumentos;
	@NotNull
	private String nombreproyecto;

	@NotNull
	private String materia;
	@NotNull
	private String tecnologia;
	
	
	@ManyToOne
	@JoinColumn(name="alumno") //la columna que se relaciona
	private Alumno alumno;
	
	/*
	 * //muchos documentos un solo alumno
	 * */
	public Integer getIddocumentos() {
		return iddocumentos;
	}
	public void setIddocumentos(Integer iddocumentos) {
		this.iddocumentos = iddocumentos;
	}
	public String getNombreproyecto() {
		return nombreproyecto;
	}
	public void setNombreproyecto(String nombreproyecto) {
		this.nombreproyecto = nombreproyecto;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

}
