package com.moisesmiiranda.projetomongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.moisesmiiranda.projetomongo.domain.Post;
import com.moisesmiiranda.projetomongo.domain.User;
import com.moisesmiiranda.projetomongo.repository.PostRepository;
import com.moisesmiiranda.projetomongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	//injentando userRepository para operação com o BD
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll(); //limpando a coleção
		postRepository.deleteAll(); //limpando a coleção
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null,sdf.parse("21/02/2021"), "Partiu viagem","Indo para Chicaco, Abraços!",maria);
		Post post2 = new Post(null,sdf.parse("23/02/2021"), "Bom dia!","Lindo dia hoje!",maria);
		
		//salvando objetos
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		postRepository.saveAll(Arrays.asList(post1,post2));
	}

}
