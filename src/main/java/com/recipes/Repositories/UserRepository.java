package com.recipes.Repositories;

import com.recipes.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findById(long id);
}