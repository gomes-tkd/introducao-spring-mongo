package io.github.gomestkd.introducaospringmongo.resources;

import io.github.gomestkd.introducaospringmongo.domain.User;
import io.github.gomestkd.introducaospringmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();

        return ResponseEntity.ok().body(users);
    }

}
