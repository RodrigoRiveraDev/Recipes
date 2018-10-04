package com.recipes.Repositories;

import com.recipes.Entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findById(long id);

    //List<User> allUsers();
}