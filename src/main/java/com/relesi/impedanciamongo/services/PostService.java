package com.relesi.impedanciamongo.services;import com.relesi.impedanciamongo.domain.Post;import com.relesi.impedanciamongo.domain.User;import com.relesi.impedanciamongo.dto.UserDTO;import com.relesi.impedanciamongo.repository.PostRepository;import com.relesi.impedanciamongo.repository.UserRepository;import com.relesi.impedanciamongo.services.exception.ObjectNotFoundException;import javafx.geometry.Pos;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.List;import java.util.Optional;@Servicepublic class PostService {    @Autowired    private PostRepository repo;    public Post findById(String id){        Optional<Post> obj = repo.findById(id);        return  obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));    }    public List<Post> findByTitle(String text){        return repo.findByTitleContainingIgnoreCase(text);    }}