package com.pcorrea.workshopmongo.config;

import com.pcorrea.workshopmongo.domain.Post;
import com.pcorrea.workshopmongo.domain.User;
import com.pcorrea.workshopmongo.dto.AuthorDTO;
import com.pcorrea.workshopmongo.repository.PostRepository;
import com.pcorrea.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration//para entender que é apenas uma configuração
public class Instantiation implements CommandLineRunner {

    //injetar o repositorio
    @Autowired
    private UserRepository userRepository;
    //injetar o repositorio
    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();// vai deletar todos os dados no mongo adicionado antes
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob)); //se não instanciar antes o userRepository será null o _id

        Post post1 = new Post(null,sdf.parse("21/03/2019"), "partiu travelling","I am goingo to travelling", new AuthorDTO(maria));
        Post post2 = new Post(null,sdf.parse("21/03/2009"), "think travelling","I am not goingo to travelling", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
