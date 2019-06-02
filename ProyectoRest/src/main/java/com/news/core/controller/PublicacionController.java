package com.news.core.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.news.core.entity.Publicacion;
import com.news.core.model.MPublicacion;
import com.news.core.service.PublicacionService;


@RestController
@RequestMapping("/v1")
public class PublicacionController {
	
	@Autowired
	@Qualifier("servicio")
	PublicacionService service;
	
	@PutMapping("/publicacion")
	public boolean agregarNota(@RequestBody @Valid Publicacion pub) {
		return service.crear(pub);
	}
	
	@PostMapping("/publicacion")
	public boolean actualizarNota(@RequestBody @Valid Publicacion pub){
		return service.actualizar(pub);
	}
	
	@DeleteMapping("/publicacion/{id}")
	public boolean borrarNota(@PathVariable("id") long id) {
		return service.borrar(id);
	}
	
	@GetMapping(value="/publicaciones")
	public List<MPublicacion> obtenerNotas(Pageable pageable){
		return service.obtenerPorPaginacion(pageable);
	}
	
}
