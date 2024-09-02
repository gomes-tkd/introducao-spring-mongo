package io.github.gomestkd.introducaospringmongo.resources;

import io.github.gomestkd.introducaospringmongo.domain.Post;
import io.github.gomestkd.introducaospringmongo.domain.User;
import io.github.gomestkd.introducaospringmongo.dto.UserDTO;
import io.github.gomestkd.introducaospringmongo.services.PostService;
import io.github.gomestkd.introducaospringmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
