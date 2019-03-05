package com.evertonpires.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertonpires.workshopmongo.domain.User;
import com.evertonpires.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	@Autowired//instanciar automaticamente um objeto na classe UserService
	private UserRepository repo;
	//retornar os usuarios do BD
	public List<User> findAll(){
		return repo.findAll();//vai no BG e retorna todos os objetos deste tipo do usuario
	}
	
}
