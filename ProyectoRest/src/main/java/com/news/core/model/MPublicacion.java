package com.news.core.model;

import com.news.core.entity.Publicacion;

public class MPublicacion {
	
	public MPublicacion() {
		
	}
	
	public MPublicacion(Publicacion pub) {
		this.id = pub.getId();
		this.url = pub.getUrl();
		this.titulo = pub.getTitulo();
		this.contenido = pub.getContenido();
	}
	
	public MPublicacion(long id, String url, String titulo, String contenido) {
		this.id = id;
		this.url = url;
		this.titulo = titulo;
		this.contenido = contenido;
	}
	
	private long id;
	
	private String url;
	
	private String titulo;
	
	private String contenido;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}
