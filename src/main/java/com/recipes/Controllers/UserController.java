package com.recipes.Controllers;

import java.util.List;
import com.recipes.Entities.User;
import com.recipes.Services.IUserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import recipes.sharedDomain.DTO.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {

    private IUserServices userServices;

    @Autowired
    public UserController(IUserServices userServices) {
        this.userServices = userServices;
    }

    /**
     * This endpoint is to add a new User
     * @param newUser The User object with the needed information (full name, password, email)
     * @return This will return a JSON with the created User object or an exception
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User newUser) throws Exception {
        return userServices.save(newUser);
    }

    /**
     * This end point is to retrieve an User object by its id
     * @param id The user id
     * @return This will return a JSON with the User object or an exception
     */
    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable int id) throws Exception {
        return userServices.findUserById(id);
    }

    /**
     * This endpoint is to update a registered User
     * @param userId The user id that is updating the user
     * @param id The user id to update the information
     * @param dataToUpdate The object with the desired information to update (full name, password, email)
     * @return This will return a JSON with the modified User object or an exception
     */
    @PutMapping(value = "/{id}")
    public User updateUser(@RequestHeader(value="userId") int userId,
                           @PathVariable int id, @RequestBody UserDTO dataToUpdate) throws Exception {
        return userServices.updateUserInfo(id, dataToUpdate, userId);
    }

    /**
     * This endpoint is to retrieve a list with all the registered users
     * @return This will return a JSON with all the registered users list
     */
    @GetMapping
    public List<User> userList() {
        return userServices.getUserList();
    }
}
