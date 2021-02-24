package com.moisesmiiranda.projetomongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moisesmiiranda.projetomongo.domain.User;
import com.moisesmiiranda.projetomongo.repository.UserRepository;

@Service
public class UserService {//serviço
	
	@Autowired
	private UserRepository repo;//acessa o repositório
	public List <User> findALL(){ //retorna todos os usuarios
		return repo.findAll();
	}
}
