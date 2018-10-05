package com.recipes.Repositories;

import com.recipes.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findById(long id);

    @Query("SELECT u FROM User u")
    List<User> allUsers();
}