package com.pcorrea.workshopmongo.services;

import com.pcorrea.workshopmongo.domain.User;
import com.pcorrea.workshopmongo.dto.UserDTO;
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
    private UserRepository repo; // <<== dependencia para o banco de dados éo UserService: dependendo da situação para instanciar o User pode ser necessario acessar o banco

    public List<User> findAll(){//responsável por retornar todos os usuarios do banco
        return repo.findAll();
    }
    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
        findById(id); // se não tiver ele ja entra na exceçao do findById()
        repo.deleteById(id);
    }

    public User fromDTO(UserDTO objDTO){ //metodo que vai buscar na classe UserService poderia ser impl no UserDTO mas já tem dependencia correspondente ao db
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
