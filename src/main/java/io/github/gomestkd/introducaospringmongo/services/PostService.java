package io.github.gomestkd.introducaospringmongo.services;

import io.github.gomestkd.introducaospringmongo.domain.Post;
import io.github.gomestkd.introducaospringmongo.repository.PostRepository;
import io.github.gomestkd.introducaospringmongo.services.execption.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Post post = postRepository.findById(id).orElse(null);

        if (post == null) {
            throw new ObjectNotFoundException("Objeto não encontrado.");
        }

        return post;
    }

}
