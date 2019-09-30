package com.pcorrea.workshopmongo.resources;

import com.pcorrea.workshopmongo.domain.User;
import com.pcorrea.workshopmongo.dto.UserDTO;
import com.pcorrea.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
