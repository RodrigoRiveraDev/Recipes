package com.recipes.Services;

import com.recipes.DTO.User;
import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices implements IUserServices {
    private List<User> userList;

    public UserServices() {
        userList = new ArrayList<>();
    }

    @Override
    public void save(User user) {
        if(!user.hasAllParameters()) {
            throw new IllegalArgumentException("All the parameters must not be nulls or empties");
        }
        user.setId(generateId());
        userList.add(user);
    }

    @Override
    public List<User> getUserList() {
        return userList;
    }

    @Override
    public User findUserbyId(int id) {
        User foundedUser = null;
        int index = userList.size();
        if(id < 0) {
            throw new IllegalArgumentException("Negative id is not valid");
        }

        while(foundedUser == null && --index >= 0) {
            foundedUser = (userList.get(index).hasId(id)) ? userList.get(index) : null;
        }

        if(foundedUser == null) {
            throw new ResourceNotFoundException(User.class, id);
        }

        return foundedUser;
    }

    @Override
    public User updateUserInfo(int id, User dataToUpdate, int userId) {
        User foundedUser = null;
        int index = userList.size();
        if(id < 0) {
            throw new IllegalArgumentException("Negative id is not valid");
        }

        while(foundedUser == null && --index >= 0) {
            foundedUser = (userList.get(index).hasId(id)) ? userList.get(index) : null;
        }

        if(foundedUser == null) {
            throw new ResourceNotFoundException(User.class, id);
        }

        if(!foundedUser.hasId(userId)) {
            throw new UnauthorizedException();
        }

        foundedUser.updateInfo(dataToUpdate);
        return foundedUser;
    }

    private int generateId() {
        if(userList.size() == 0) {
            return 1;
        } else {
            return userList.get(userList.size() - 1).getId() + 1;
        }
    }
}
