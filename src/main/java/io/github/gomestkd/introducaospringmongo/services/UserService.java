package io.github.gomestkd.introducaospringmongo.services;

import io.github.gomestkd.introducaospringmongo.domain.User;
import io.github.gomestkd.introducaospringmongo.dto.UserDTO;
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

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User obj) {
        User user = findById(obj.getId());
        updateData(user, obj);
        return userRepository.save(user);
    }

    private void updateData(User user, User obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
