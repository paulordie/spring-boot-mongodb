package com.pcorrea.workshopmongo.resources;

import com.pcorrea.workshopmongo.domain.User;
import com.pcorrea.workshopmongo.dto.UserDTO;
import com.pcorrea.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController //para informar que essa classe será um recurso REST
@RequestMapping(value="/users") //para informar o caminho do endpoint
public class UserResource {

    @Autowired
    private UserService service; //controlador REST vai conversar com o serviço

    @RequestMapping(method = RequestMethod.GET) // para dizer que esse metodo será RES no caminho /users == @GetMapping
    public ResponseEntity <List<UserDTO>> findAll(){ //ResponseEntity para retornar respostas http e outros dados corrigidos ou erros
        List<User> list = service.findAll(); //vai buscar no banco de dados e salvar na lista
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); //converte list para listDto
        return ResponseEntity.ok().body(listDto); //retornar na resposta da requisição
    }
    @RequestMapping(value ="/{id}", method = RequestMethod.GET) // para retornar do metodo UserDTO
    public ResponseEntity <UserDTO> findById(@PathVariable String id){ //para que o id case com o id da URL usar o metodo @PathVariable
        User obj = service.findById(id);

        return ResponseEntity.ok().body(new UserDTO(obj)); //retornar na resposta da requisição UserDTO
    }
//    @RequestMapping(method = RequestMethod.POST) // notação para post insert()
    @PostMapping
    public ResponseEntity <Void> insert(@RequestBody UserDTO objDto){ //para que o endpoint aceite o obj deve-se colocar @RequestBody
        User obj = service.fromDTO(objDto); //converter o metodo DTO para User
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //vai pegar o endereço do novo obj construido
        return ResponseEntity.created(uri).build(); //volta codigo de resposta 201 e o uri é o cabeçalho contendo a localização do novo recurso
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE) // para retornar do metodo UserDTO
    public ResponseEntity <Void> delete(@PathVariable String id){ //vai receber uma resposta vazia do delete
        service.delete(id);

        return ResponseEntity.noContent().build(); // retorno o codigo 204 quando não retorna nada
    }

}
