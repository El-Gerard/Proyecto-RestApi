package com.news.core.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.news.core.entity.Publicacion;
import com.news.core.model.MPublicacion;


@Component("convertidor")
public class Convertidor{
	public List<MPublicacion> convertirLista(List<Publicacion> pubs){
		List<MPublicacion> mpubs = new ArrayList<>();
		
		for(Publicacion pub : pubs) {
			mpubs.add(new MPublicacion(pub));
		}
		return mpubs;
	}
}
