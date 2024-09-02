package io.github.gomestkd.introducaospringmongo.resources;

import io.github.gomestkd.introducaospringmongo.domain.Post;
import io.github.gomestkd.introducaospringmongo.domain.User;
import io.github.gomestkd.introducaospringmongo.dto.UserDTO;
import io.github.gomestkd.introducaospringmongo.resources.util.URL;
import io.github.gomestkd.introducaospringmongo.services.PostService;
import io.github.gomestkd.introducaospringmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.UnsupportedEncodingException;
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


    @RequestMapping(value="/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) throws UnsupportedEncodingException {
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
