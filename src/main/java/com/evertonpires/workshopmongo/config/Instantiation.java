package com.evertonpires.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.evertonpires.workshopmongo.domain.User;
import com.evertonpires.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;//fazer operação com o BD

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();//isso ira limpar a coleção la no MongoDB
		
		//Id nulo pois o BD quem ira gerar
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//salvar os 3 objetos "maria" , "alex" , "bob"
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
	}

}
