package com.recipes.Repositories;

import com.recipes.Entities.Recipe;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Recipe findById(long id);

    @Query("SELECT r FROM Recipe r")
    List<Recipe> findAll();

    @Transactional
    @Modifying
    @Query("DELETE FROM Recipe r WHERE r.id = :id AND r.userId = :userId")
    void delete(@Param("id") long recipeId,
                @Param("userId") long userId);
}
