package com.moisesmiiranda.projetomongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moisesmiiranda.projetomongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findALL(){
		User maria = new User("1","maria brow", "maria@gmail.com");
		User moises = new User("2","moises miranda", "moises@gmail.com");
		List<User> list	= new ArrayList<>();
		list.addAll(Arrays.asList(maria, moises));
		return ResponseEntity.ok().body(list);	
	}
	

}
