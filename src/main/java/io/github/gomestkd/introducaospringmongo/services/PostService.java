package io.github.gomestkd.introducaospringmongo.services;

import io.github.gomestkd.introducaospringmongo.domain.Post;
import io.github.gomestkd.introducaospringmongo.repository.PostRepository;
import io.github.gomestkd.introducaospringmongo.services.execption.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public List<Post> findByTitle(String title) {
        return postRepository.searchTitle(title);
    }


    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + (24 * 60 * 60 * 1000));
        return postRepository.fullSearch(text, minDate, maxDate);
    }

}
