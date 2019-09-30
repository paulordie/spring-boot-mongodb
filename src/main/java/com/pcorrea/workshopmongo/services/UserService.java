package com.pcorrea.workshopmongo.services;

import com.pcorrea.workshopmongo.domain.User;
import com.pcorrea.workshopmongo.repository.UserRepository;
import com.pcorrea.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //para instanciar repositorio para falar com servicos @Autowired mecanismo de injeção automatica do spring
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){//responsável por retornar todos os usuarios do banco
        return repo.findAll();
    }
    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
