package com.pcorrea.workshopmongo.services;

import com.pcorrea.workshopmongo.domain.Post;
import com.pcorrea.workshopmongo.domain.User;
import com.pcorrea.workshopmongo.dto.UserDTO;
import com.pcorrea.workshopmongo.repository.PostRepository;
import com.pcorrea.workshopmongo.repository.UserRepository;
import com.pcorrea.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    //para instanciar repositorio para falar com servicos @Autowired mecanismo de injeção automatica do spring
    @Autowired
    private PostRepository repo; // <<== dependencia para o banco de dados é o PostService: dependendo da situação para instanciar o User pode ser necessario acessar o banco

    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTItle(String text){ //metodo para buscar title na url
//        return repo.findByTitleContaining(text);
//        return repo.findByTitleContainingIgnoreCase(text);
        return repo.searchTitle(text);
    }
}
