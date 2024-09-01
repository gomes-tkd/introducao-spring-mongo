package io.github.gomestkd.introducaospringmongo.repository;

import io.github.gomestkd.introducaospringmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> { }
