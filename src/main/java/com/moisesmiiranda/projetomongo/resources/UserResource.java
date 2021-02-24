package com.moisesmiiranda.projetomongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moisesmiiranda.projetomongo.domain.User;
import com.moisesmiiranda.projetomongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {//controlador rest
	
	@Autowired
	private UserService service;//acessa o serviço

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findALL(){
		List<User> list	= service.findALL(); 
		return ResponseEntity.ok().body(list);	
	}
	

}
