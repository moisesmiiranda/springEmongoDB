package com.moisesmiiranda.projetomongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moisesmiiranda.projetomongo.domain.Post;
import com.moisesmiiranda.projetomongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {// controlador rest

	@Autowired
	private PostService service;// acessa o serviço


	//Buscar usuario por ID
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
