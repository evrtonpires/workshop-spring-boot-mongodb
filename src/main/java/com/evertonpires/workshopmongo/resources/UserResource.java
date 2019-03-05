package com.evertonpires.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.evertonpires.workshopmongo.domain.User;
import com.evertonpires.workshopmongo.dto.UserDTO;
import com.evertonpires.workshopmongo.service.UserService;

@RestController//classe de recursuo Rest
@RequestMapping(value="/users")//caminho do enpoint
public class UserResource {//controlador rest
	
	@Autowired
	private UserService service;//controlador rest, acessa o serviço
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>>findAll(){
		
	List<User> list = service.findAll();//busca os usuarios no banco de dados e guarda na Lista "list"
	List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	//map, pega cada obj " X "  da list original, e retorna um new UserDTO, passando "X" como argumento
	
	
	//devolve a lista na resposta da requisicao
	return ResponseEntity
			.ok()//Método que instacia o ResponseEntity já com o codigo de resposta HTTP que a resposta ocorreu com sucesso
			.body(listDto);// definir o corpo da resposta
	
	//ResponseEntity :  Retorna um objeto sofisticado, que encapsula uma estrutura necessaria
	//para retornar respostas HTTP já com possiveis cabeçalhos , erros etc
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<UserDTO>findById(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	//inserir um novo usuario
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO objDto){
		User obj = service.FromDTO(objDto);//converteu o DTO para User
		obj = service.insert(obj);//inseriu no BD
		
		//pega o endereço do novo objeto que foi inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();//created retorna o código 201, que é o codigo de resposta HTTP quando voce cria um novo recurso
		//este código retorna uma resposta vazia, com o código 201, e com o cabeçalhjo contendo a localizacao do novo recurso criado
	}
}
