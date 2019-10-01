package com.pcorrea.workshopmongo.repository;

import com.pcorrea.workshopmongo.domain.Post;
import com.pcorrea.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //informar que é um repositorio
public interface PostRepository extends MongoRepository<Post, String> { //<class, tipo>
    //salvar, deletar, atualizar
    //@Query("{ <field>: { $regex: /pattern/, $options: '<options>' } }")// ?0 == é o primeiro parametro e assim por diante, e 'i' para ignorar letras maiusculas e minusculas
    @Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text); //consulta personalizada na forma de json atraves do @query

    //List<Post> findByTitleContaining(String text); // para buscar posts de um dado string no titulo com URI e adicionar no metodo de busca no PostService -  o spring data monta a consulta (findBy+'Title'+Containing =>squerymothods do springboot ver documents)
    List<Post> findByTitleContainingIgnoreCase(String text); // vai ignorar caso de letras maiusculas e minusculas (atualizar no service)
}
