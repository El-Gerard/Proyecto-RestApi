/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.core.controller;

import com.news.core.entity.Publicacion;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/publicacion")
public class ClienteRest {
    
    private final String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkYXZpZGJyaW9uZXMifQ.74o-HxtdCtSv4HD6ADn7TgLv2qUDdESR5J_kk8FdGTo43psguoL6Pi37ktuPlJSrRXhkUFIQvxaN0pX4cLvsww";
    
    @GetMapping("/all")
    public ModelAndView devolvertodos(){
        ModelAndView mav = new ModelAndView("template");
        
        RestTemplate rest = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.add("Authorization", token);
        
        HttpEntity entity = new HttpEntity(headers);
        
        ResponseEntity<Publicacion[]> notasEntity = rest.exchange("http://localhost:8090/v1/publicaciones",HttpMethod.GET,entity, Publicacion[].class);
        
        Publicacion[] publicaciones = notasEntity.getBody();
        
        mav.addObject("publicacion",publicaciones);
        return mav;
    }
    
}
