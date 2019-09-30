package com.pcorrea.workshopmongo.resources;

import com.pcorrea.workshopmongo.domain.User;
import com.pcorrea.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController //para informar que essa classe será um recurso REST
@RequestMapping(value="/users") //para informar o caminho do endpoint
public class UserResource {

    @Autowired
    private UserService service; //controlador REST vai conversar com o serviço

    @RequestMapping(method = RequestMethod.GET) // para dizer que esse metodo será RES no caminho /users == @GetMapping
    public ResponseEntity <List<User>> findAll(){ //ResponseEntity para retornar respostas http e outros dados corrigidos ou erros

        List<User> list = service.findAll(); //vai buscar no banco de dados e salvar na lista
        return ResponseEntity.ok().body(list); //retornar na resposta da requisição
    }
}
