package com.moisesmiiranda.projetomongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.moisesmiiranda.projetomongo.domain.User;
import com.moisesmiiranda.projetomongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	//injentando userRepository para operação com o BD
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll(); //limpando a coleção
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//salvando objetos
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
	}

}
