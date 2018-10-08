package com.recipes.Services;

import com.recipes.DTO.UserDTO;
import com.recipes.Entities.User;
import com.recipes.Exceptions.UnauthorizedException;
import com.recipes.Repositories.UserRepository;
import com.recipes.Utilitaries.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices implements IUserServices {

    private UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(UserDTO user) {
        userRepository.save(Factory.toUser(user));
    }

    @Override
    public List<User> getUserList() {
        return userRepository.allUsers();
    }

    @Override
    public User findUserbyId(long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDTO updateUserInfo(int userIdToUpdate, UserDTO dataToUpdate, int requestUserId) {
        if(userIdToUpdate == requestUserId) {
            User foundUser = userRepository.findById(userIdToUpdate);
            if(!dataToUpdate.getEmail().isEmpty()) {
                foundUser.setEmail(dataToUpdate.getEmail());
            }
            if(!dataToUpdate.getPassword().isEmpty()) {
                foundUser.setPassword(dataToUpdate.getPassword());
            }
            if(!dataToUpdate.getFullName().isEmpty()) {
                foundUser.setFullName(dataToUpdate.getFullName());
            }
            userRepository.save(foundUser);
            return Factory.toUserDTO(foundUser);
        } else {
            throw new UnauthorizedException();
        }
    }
}
