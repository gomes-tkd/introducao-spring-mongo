package io.github.gomestkd.introducaospringmongo.config;

import io.github.gomestkd.introducaospringmongo.domain.Post;
import io.github.gomestkd.introducaospringmongo.domain.User;
import io.github.gomestkd.introducaospringmongo.dto.AuthorDTO;
import io.github.gomestkd.introducaospringmongo.dto.CommentDTO;
import io.github.gomestkd.introducaospringmongo.repository.PostRepository;
import io.github.gomestkd.introducaospringmongo.repository.UserRepository;
import io.github.gomestkd.introducaospringmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        postRepository.deleteAll();
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(
                null, sdf.parse("21/03/2018"),
                "Partiu viagem", "Vou viajar para o Canadá. Abraços.",
                new AuthorDTO(maria)
        );

        Post post2 = new Post(
                null, sdf.parse("21/03/2018"),
                "Bom dia!", "Tomando um café com muita força jedi. Bençãos e abraços.",
                new AuthorDTO(alex)
        );

        CommentDTO c1 = new CommentDTO("Boa viagem guria!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("21/03/2018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenhas um ótimo dia!", sdf.parse("21/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.setPosts(Arrays.asList(post1));
        alex.setPosts(Arrays.asList(post2));

        userRepository.saveAll(Arrays.asList(alex, maria));
    }
}
