package com.evertonpires.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertonpires.workshopmongo.domain.Post;
import com.evertonpires.workshopmongo.repository.PostRepository;
import com.evertonpires.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired//instanciar automaticamente um objeto na classe UserService
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(String.format("Objeto não encontrado",id)));
		}

	public List<Post> findByTitle(String text){//metodo de consulta
		return repo.findByTitleContainingIgnoreCase(text);
	}
	
}
