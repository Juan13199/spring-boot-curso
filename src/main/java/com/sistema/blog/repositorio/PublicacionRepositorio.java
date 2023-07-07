package com.sistema.blog.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.blog.modelo.Publicacion;

public interface PublicacionRepositorio  extends JpaRepository<Publicacion, Long>{

}
