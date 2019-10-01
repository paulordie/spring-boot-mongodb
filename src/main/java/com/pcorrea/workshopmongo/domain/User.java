package com.pcorrea.workshopmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//para informar que classe user corresponde a uma coleção do mongodb @Document ou @Document(collection="user")
@Document(collection = "user")
public class User implements Serializable { //implements Serializable => para os dados serem trafegaveis em rede
    //private static final long serialVersionUID = 1L; //caso precise para serializer!! @Id é a onde é a Chave
    @Id
    private String id;
    private String name;
    private String email;
    //(lazy = true) vai garantir que a lista de posts não vai sobrecarregar e somente quando for solicitado e somente os dados basicos do usuario
    @DBRef(lazy = true)
    private List<Post>posts = new ArrayList<>();


    public User(){

    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


