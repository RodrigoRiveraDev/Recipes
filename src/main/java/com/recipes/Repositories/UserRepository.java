package com.recipes.Repositories;

import com.recipes.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * @param id The user id to search for
     * @return It will return the entity with the provided id or null
     */
    User findById(@Param("id") long id);

    /**
     * @return It will retrieve a list with all the registered users
     */
    @Query("SELECT u FROM User u")
    List<User> allUsers();

    /**
     * @param fullName The user fullName to search for
     * @param email The user email to search for
     * @return It will return the entity with the provided fullName and email or null
     */
    @Query("SELECT u FROM User u WHERE u.fullName = :fullName AND u.email = :email")
    User findUser(@Param("fullName") String fullName, @Param("email") String email);
}