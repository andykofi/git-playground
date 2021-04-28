package com.play.gitplayground.Repository;


import java.util.List;

import com.play.gitplayground.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, Integer>{
    List<User> findByAddress(String address);
}