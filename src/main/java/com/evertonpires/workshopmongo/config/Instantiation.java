package com.evertonpires.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.evertonpires.workshopmongo.domain.Post;
import com.evertonpires.workshopmongo.domain.User;
import com.evertonpires.workshopmongo.dto.AuthorDTO;
import com.evertonpires.workshopmongo.repository.PostRepository;
import com.evertonpires.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;//fazer operação com o BD
	
	@Autowired
	private PostRepository postRepository;//fazer operação com o BD

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));//horaio de londres
		
		userRepository.deleteAll();//isso ira limpar a coleção la no MongoDB
		postRepository.deleteAll();//isso ira limpar a coleção la no MongoDB
		
		//Id nulo pois o BD quem ira gerar
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//salvar os 3 objetos "maria" , "alex" , "bob"
		userRepository.saveAll(Arrays.asList(maria,alex,bob));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem!", "Vou viajar para São Paulo. Abraços!",new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom Dia","Acordei Feliz Hoje!",new AuthorDTO(maria));
	
		postRepository.saveAll(Arrays.asList(post1,post2));
		
	}
}
