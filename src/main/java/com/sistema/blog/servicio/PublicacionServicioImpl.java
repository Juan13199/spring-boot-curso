package com.sistema.blog.servicio;

import java.util.List;
import java.util.stream.Collectors;

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
		
		Publicacion publicacion= mapearEntidad(publicacionDTO);
		Publicacion nuevaPublicacion= publicacionRepositiorio.save(publicacion);
		
		//Convertimos de entidad a DTO
		PublicacionDTO publicacionRespuesta = mapearDTO(nuevaPublicacion);
		
		return publicacionRespuesta;
	}

	@Override
	public List<PublicacionDTO> obtenerPublicaciones() {
		List<Publicacion> publicaciones= publicacionRepositiorio.findAll();
		return publicaciones.stream().map(publicacion -> mapearDTO(publicacion) ).collect(Collectors.toList());
		//return null;
	}
	
	//Convierte a DTO
	private PublicacionDTO mapearDTO(Publicacion publicacion) {
		
		PublicacionDTO publicacionDTO= new PublicacionDTO();
		
		publicacionDTO.setId(publicacion.getId());
		publicacionDTO.setTitulo(publicacion.getTitulo());
		publicacionDTO.setDescripcion(publicacion.getDescripcion());
		publicacionDTO.setContenido(publicacion.getContenido());
		
		return publicacionDTO;
	}
	
	//Convierte a entidad
	private Publicacion mapearEntidad(PublicacionDTO publicacionDTO) {
			
			Publicacion publicacion= new Publicacion();
			//publicacion.setId(publicacionDTO.getId());
			publicacion.setTitulo(publicacionDTO.getTitulo());
			publicacion.setDescripcion(publicacionDTO.getDescripcion());
			publicacion.setContenido(publicacionDTO.getContenido());
			
			return publicacion;
		}
}
