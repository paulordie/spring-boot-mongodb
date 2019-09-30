package com.pcorrea.workshopmongo.services;

import com.pcorrea.workshopmongo.domain.User;
import com.pcorrea.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //para instanciar repositorio para falar com servicos @Autowired mecanismo de injeção automatica do spring
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){//responsável por retornar todos os usuarios do banco
        return repo.findAll();
    }
}
