package com.pcorrea.workshopmongo.repository;

import com.pcorrea.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository //informar que é um repositorio
public interface UserRepository extends MongoRepository<User, String> { //<class, tipo>
    //salvar, deletar, atualizar
}
