package com.evertonpires.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.evertonpires.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	//serviço acessa o repositorio
	
	List<Post> findByTitleContainingIgnoreCase(String text);//montando consulta
	//IgnoreCase : ignora letras maiusculas e minusculas
}
