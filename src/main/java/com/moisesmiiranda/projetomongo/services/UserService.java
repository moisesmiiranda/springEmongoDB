package com.moisesmiiranda.projetomongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moisesmiiranda.projetomongo.domain.User;
import com.moisesmiiranda.projetomongo.repository.UserRepository;
import com.moisesmiiranda.projetomongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {//serviço
	
	@Autowired
	private UserRepository repo;//acessa o repositório
	public List <User> findALL(){ //retorna todos os usuarios
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
