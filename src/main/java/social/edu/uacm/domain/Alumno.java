package social.edu.uacm.domain;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="alumno")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotNull
	private String nombre;
	@NotNull
	private String nombreusuario;
	@NotNull
	private String contrasena;
	
	
	//Lista de documentos archivos subidos
	/*@OneToMany(mappedBy="alumno")  //forma parte de la relacion 
	private List<Documento> listaDocumentos;
	*/
	
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@NotNull
	private String email;
	@NotNull
	private Integer plantel;
	@NotNull
	private String telefono;
	@NotNull
	private String web;

	@OneToMany(mappedBy="alumno")   
	private List<Documento> documentos;

	
	public List<Documento> getDocumentos() {
		return documentos;
	}
	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
	public String getNombre() {
		return nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPlantel() {
		return plantel;
	}
	public void setPlantel(Integer plantel) {
		this.plantel = plantel;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}


}
