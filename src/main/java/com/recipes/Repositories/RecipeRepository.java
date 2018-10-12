package com.recipes.Repositories;

import com.recipes.Entities.Recipe;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    /**
     * @param id The recipe id to search for
     * @return It will return the entity with the provided id or null
     */
    Recipe findById(long id);

    @Query("SELECT r FROM Recipe r")
    List<Recipe> findAll();

    /**
     * @param recipeId The recipe id to delete
     * @param userId The owner recipe id
     */
    @Transactional
    @Modifying
    @Query("DELETE FROM Recipe r WHERE r.id = :id AND r.userId = :userId")
    void delete(@Param("id") long recipeId,
                @Param("userId") long userId);
}
