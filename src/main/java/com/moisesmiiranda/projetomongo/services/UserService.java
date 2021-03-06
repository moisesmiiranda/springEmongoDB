package com.moisesmiiranda.projetomongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moisesmiiranda.projetomongo.domain.User;
import com.moisesmiiranda.projetomongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete (String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update (User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		
	}
	
	public void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
