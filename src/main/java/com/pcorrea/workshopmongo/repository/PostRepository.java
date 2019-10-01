package com.pcorrea.workshopmongo.repository;

import com.pcorrea.workshopmongo.domain.Post;
import com.pcorrea.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //informar que é um repositorio
public interface PostRepository extends MongoRepository<Post, String> { //<class, tipo>
    //salvar, deletar, atualizar
    //List<Post> findByTitleContaining(String text); // para buscar posts de um dado string no titulo com URI e adicionar no metodo de busca no PostService -  o spring data monta a consulta (findBy+'Title'+Containing =>squerymothods do springboot ver documents)
    List<Post> findByTitleContainingIgnoreCase(String text); // vai ignorar caso de letras maiusculas e minusculas (atualizar no service)
}
