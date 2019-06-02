package com.news.core.service;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.news.core.converter.Convertidor;
import com.news.core.entity.Publicacion;
import com.news.core.model.MPublicacion;
import com.news.core.repository.PublicacionRepositorio;

@Service("servicio")
public class PublicacionService {
	@Autowired
	@Qualifier("repositorio")
	private PublicacionRepositorio repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	private static final Log logger = LogFactory.getLog(PublicacionService.class);
	
	public boolean crear(Publicacion pub){
		logger.info("CREANDO PUBLICACION");
		try {
			repositorio.save(pub);
			logger.info("PUBLICACION CREADA");
			return true;
		}catch(Exception e) {
			logger.error("HUBO UN ERROR");
			return false;
		}
	}
	
	public boolean actualizar(Publicacion pub){
		logger.info("ACTUALIZANDO PUBLICACION");
		try {
			repositorio.save(pub);
			logger.info("PUBLICACION ACTUALIZADA");
			return true;
		}catch(Exception e) {
			logger.error("HUBO UN ERROR");
			return false;
		}
	}
	
	public boolean borrar(long id) {
		logger.warn("BORRANDO PUBLICACION");
		try {
			
			Publicacion pub = repositorio.findById(id);
			repositorio.delete(pub);
			logger.info("PUBLICACION BORRADA");
			return true;
		}catch(Exception e) {
			logger.error("HUBO UN ERROR");
			return false;
		}
	}
	
	public List<MPublicacion> obtener(){
		logger.info("OBTENIENDO TODOS LOS ELEMENTOS");
		return convertidor.convertirLista(repositorio.findAll());
	}
	
	public MPublicacion obtenerPorUrlTitulo(String url, String titulo) {
		return new MPublicacion(repositorio.findByUrlAndTitulo(url, titulo));
	}
	
	public List<MPublicacion> obtenerTitulo(String titulo){
		return convertidor.convertirLista(repositorio.findByTitulo(titulo));
	}
	
	public List<MPublicacion> obtenerPorPaginacion(Pageable pageable){
		return convertidor.convertirLista(repositorio.findAll(pageable).getContent());
	}
}
