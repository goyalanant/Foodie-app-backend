package com.example.jaypee.CartService.repository;

import com.example.jaypee.CartService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    @Query("{'email' : ?0}")
    public User getUserByEmail(String email);
}
