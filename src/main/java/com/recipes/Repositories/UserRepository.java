package com.recipes.Repositories;

import com.recipes.DTO.UserDTO;
import com.recipes.Entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findById(@Param("id") long id);

    @Query("SELECT u FROM User u")
    List<User> allUsers();

}