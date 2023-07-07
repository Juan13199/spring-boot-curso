package com.sistema.blog.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.blog.dto.PublicacionDTO;
import com.sistema.blog.modelo.Publicacion;
import com.sistema.blog.repositorio.PublicacionRepositorio;

@Service
public class PublicacionServicioImpl implements PublicacionServicio {

	
	@Autowired
	private PublicacionRepositorio publicacionRepositiorio;
	
	@Override
	public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO) {
		//Convertimos DTO a entidad
		
		Publicacion publicacion= new Publicacion();
		publicacion.setTitulo(publicacionDTO.getTitulo());
		publicacion.setDescripcion(publicacionDTO.getDescripcion());
		publicacion.setContenido(publicacionDTO.getContenido());
		Publicacion nuevaPublicacion= publicacionRepositiorio.save(publicacion);
		
		//Convertimos de entidad a DTO
		PublicacionDTO publicacionRespuesta = new PublicacionDTO();
		
		publicacionRespuesta.setId(nuevaPublicacion.getId());
		publicacionRespuesta.setTitulo(nuevaPublicacion.getTitulo());
		publicacionRespuesta.setDescripcion(nuevaPublicacion.getDescripcion());
		publicacionRespuesta.setContenido(nuevaPublicacion.getContenido());
		
		return publicacionRespuesta;
	}

}
