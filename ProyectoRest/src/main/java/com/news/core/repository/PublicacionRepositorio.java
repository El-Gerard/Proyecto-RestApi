package com.news.core.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.news.core.entity.Publicacion;

@Repository("repositorio")
public interface PublicacionRepositorio extends JpaRepository<Publicacion, Serializable>, PagingAndSortingRepository<Publicacion, Serializable>{
	
	public abstract Publicacion findByUrl(String url);
	
	public abstract List<Publicacion> findByTitulo(String titulo);
	
	public abstract Publicacion findByUrlAndTitulo(String url, String titulo);

	public abstract Publicacion findById(long id);
	
	public abstract Page<Publicacion> findAll(Pageable pageable);
}
