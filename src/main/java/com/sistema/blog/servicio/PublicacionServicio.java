package com.sistema.blog.servicio;

import java.util.List;

import com.sistema.blog.dto.PublicacionDTO;
import com.sistema.blog.modelo.Publicacion;

public interface PublicacionServicio {

	
	public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO);
	public List<PublicacionDTO> obtenerPublicaciones();

}
