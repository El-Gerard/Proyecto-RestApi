package com.news.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Table(name="Publicaciones")
@Entity
public class Publicacion implements Serializable{
	
	public Publicacion(){
		
	}
	
	public Publicacion(long id, String url, String titulo, String contenido) {
		this.id = id;
		this.url = url;
		this.titulo = titulo;
		this.contenido = contenido;
	}

	@GeneratedValue
	@Id
	@Column(name="ID_PUBLICACION")
	private long id;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="CONTENIDO")
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
