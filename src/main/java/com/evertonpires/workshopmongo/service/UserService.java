package com.evertonpires.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertonpires.workshopmongo.domain.User;
import com.evertonpires.workshopmongo.dto.UserDTO;
import com.evertonpires.workshopmongo.repository.UserRepository;
import com.evertonpires.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired//instanciar automaticamente um objeto na classe UserService
	private UserRepository repo;
	//retornar os usuarios do BD
	public List<User> findAll(){
		return repo.findAll();//vai no BG e retorna todos os objetos deste tipo do usuario
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(String.format("Objeto não encontrado",id)));
		}
	//inserir
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User FromDTO(UserDTO objDTO) {
		return new User(objDTO.getId() , objDTO.getNome() , objDTO.getEmail());
	}
}
