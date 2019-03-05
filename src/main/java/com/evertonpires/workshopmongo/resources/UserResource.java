package com.evertonpires.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evertonpires.workshopmongo.domain.User;
import com.evertonpires.workshopmongo.service.UserService;

@RestController//classe de recursuo Rest
@RequestMapping(value="/users")//caminho do enpoint
public class UserResource {//controlador rest
	
	@Autowired
	private UserService service;//controlador rest, acessa o serviço
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>>findAll(){
		
	List<User> list = service.findAll();//busca os usuarios no banco de dados e guarda na Lista "list"
	//devolve a lista na resposta da requisicao
	return ResponseEntity
			.ok()//Método que instacia o ResponseEntity já com o codigo de resposta HTTP que a resposta ocorreu com sucesso
			.body(list);// definir o corpo da resposta
	
	//ResponseEntity :  Retorna um objeto sofisticado, que encapsula uma estrutura necessaria
	//para retornar respostas HTTP já com possiveis cabeçalhos , erros etc
	}
}
