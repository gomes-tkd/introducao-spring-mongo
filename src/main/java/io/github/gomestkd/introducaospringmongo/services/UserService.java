package io.github.gomestkd.introducaospringmongo.services;

import io.github.gomestkd.introducaospringmongo.domain.User;
import io.github.gomestkd.introducaospringmongo.repository.UserRepository;
import io.github.gomestkd.introducaospringmongo.services.execption.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado.");
        }

        return user;
    }
}
