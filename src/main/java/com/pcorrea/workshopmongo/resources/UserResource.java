package com.pcorrea.workshopmongo.resources;

import com.pcorrea.workshopmongo.domain.User;
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
    @RequestMapping(method = RequestMethod.GET) // para dizer que esse metodo será RES no caminho /users == @GetMapping
    public ResponseEntity <List<User>> findAll(){ //ResponseEntity para retornar respostas http e outros dados corrigidos ou erros
        User paulo = new User("1", "Paulo Correa","pc.rochacorrea@gmail.com");
        User mel = new User("2", " Mel Guilia","mel.guilia@gmail.com");
        User maria = new User("3", "Maria Brown","maria@gmail.com");
        User giselle = new User("4", "Giselle Beatriz","giselle.beatriz@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(paulo,mel,maria,giselle));
        return ResponseEntity.ok().body(list);
    }
}
