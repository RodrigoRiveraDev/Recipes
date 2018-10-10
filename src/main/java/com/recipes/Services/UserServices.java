package com.recipes.Services;

import com.recipes.DTO.UserDTO;
import com.recipes.Entities.User;
import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;
import com.recipes.Exceptions.ResourceAlreadyExistsException;
import com.recipes.Repositories.UserRepository;
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
    public User save(User user) throws ResourceAlreadyExistsException {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUserList() {
        return userRepository.allUsers();
    }

    @Override
    public User findUserById(long id) throws ResourceNotFoundException {
        User foundUser = userRepository.findById(id);
        if(foundUser == null) {
            throw new ResourceNotFoundException(User.class, id);
        }
        return foundUser;
    }

    @Override
    public User updateUserInfo(int userIdToUpdate, UserDTO dataToUpdate, int requestUserId)
            throws UnauthorizedException, ResourceNotFoundException {
        if(userIdToUpdate == requestUserId) {
            User foundUser = userRepository.findById(userIdToUpdate);
            if(foundUser == null) {
                throw new ResourceNotFoundException(User.class, userIdToUpdate);
            }

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
            return foundUser;
        } else {
            throw new UnauthorizedException();
        }
    }
}
