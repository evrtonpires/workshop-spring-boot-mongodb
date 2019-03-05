package com.evertonpires.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.evertonpires.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	//serviço acessa o repositorio
	
}
