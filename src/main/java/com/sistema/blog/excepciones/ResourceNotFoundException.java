package com.sistema.blog.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String nombreDelRecurso;
	private String nombreDelCampo;
	private long valoDelCampo;

	public ResourceNotFoundException(String nombreDelRecurso, String nombreDelCampo, long valoDelCampo) {
		super(String.format("%s No encontrado con : %s : '%s'", nombreDelRecurso, nombreDelCampo, valoDelCampo));
		this.nombreDelRecurso = nombreDelRecurso;
		this.nombreDelCampo = nombreDelCampo;
		this.valoDelCampo = valoDelCampo;
	}

	public String getNombreDelRecurso() {
		return nombreDelRecurso;
	}

	public void setNombreDelRecurso(String nombreDelRecurso) {
		this.nombreDelRecurso = nombreDelRecurso;
	}

	public String getNombreDelCampo() {
		return nombreDelCampo;
	}

	public void setNombreDelCampo(String nombreDelCampo) {
		this.nombreDelCampo = nombreDelCampo;
	}

	public long getValoDelCampo() {
		return valoDelCampo;
	}

	public void setValoDelCampo(long valoDelCampo) {
		this.valoDelCampo = valoDelCampo;
	}

}
