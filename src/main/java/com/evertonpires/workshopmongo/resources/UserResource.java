package com.evertonpires.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evertonpires.workshopmongo.domain.User;

@RestController//classe de recursuo Rest
@RequestMapping(value="/users")//caminho do enpoint
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>>findAll(){
		
	User maria = new User("1","Maria Brown", "maria@gmail.com");
	User alex= new User("2","Alex Green ", "alex@gmail.com");
	List<User> list = new ArrayList<User>();
	list.addAll(Arrays.asList(maria,alex)); // adiciona todos os objetos na lista 
	return ResponseEntity
			.ok()//Método que instacia o ResponseEntity já com o codigo de resposta HTTP que a resposta ocorreu com sucesso
			.body(list);// definir o corpo da resposta
	
	//ResponseEntity :  Retorna um objeto sofisticado, que encapsula uma estrutura necessaria
	//para retornar respostas HTTP já com possiveis cabeçalhos , erros etc
	}
}
