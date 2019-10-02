package com.pcorrea.workshopmongo.resources;

import com.pcorrea.workshopmongo.domain.Post;
import com.pcorrea.workshopmongo.domain.User;
import com.pcorrea.workshopmongo.dto.UserDTO;
import com.pcorrea.workshopmongo.resources.util.URL;
import com.pcorrea.workshopmongo.services.PostService;
import com.pcorrea.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController //para informar que essa classe será um recurso REST
@RequestMapping(value="/posts") //para informar o caminho do endpoint
public class PostResource {

    @Autowired
    private PostService service; //controlador REST vai conversar com o serviço

    @RequestMapping(value ="/{id}", method = RequestMethod.GET) // para retornar do metodo UserDTO
    public ResponseEntity <Post> findById(@PathVariable String id){ //para que o id case com o id da URL usar o metodo @PathVariable
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj); //retornar na resposta da requisição UserDTO
    }

    @RequestMapping(value ="titlesearch", method = RequestMethod.GET) // para retornar do metodo UserDTO
    public ResponseEntity <List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text){ //vai retornar uma lista; @RequestParam par dizer que é um parametro de busca setado com valor text no endpoint titlesearch
        text = URL.decodeParam(text); // para decodificar o parametro text
        List<Post> list = service.findByTItle(text); //declarar uma lista de post recebendo uma lista de title do text
        return ResponseEntity.ok().body(list); //retornar na resposta da requisição com o corpo de uma lista
    }

    @RequestMapping(value ="fullsearch", method = RequestMethod.GET) // busca completa
    public ResponseEntity <List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue = "") String text,
            @RequestParam(value="minDate", defaultValue = "") String minDate,
            @RequestParam(value="maxDate", defaultValue = "") String maxDate){
        text = URL.decodeParam(text); // para decodificar o parametro text
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = service.fullSearch(text,min, max); //
        return ResponseEntity.ok().body(list); //
    }
}
