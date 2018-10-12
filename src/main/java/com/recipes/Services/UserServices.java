package com.recipes.Services;

import com.recipes.Entities.User;
import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;
import com.recipes.Exceptions.ResourceAlreadyExistsException;
import com.recipes.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.sharedDomain.DTO.UserDTO;

import java.util.List;

@Service
public class UserServices implements IUserServices {

    private UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param user The User information to be stored
     * @return It will return the user that has been stored
     * @throws ResourceAlreadyExistsException In case that there is a user with the same provided data stored
     */
    @Override
    public User save(User user) throws ResourceAlreadyExistsException {
        User userInDB = userRepository.findUser(user.getFullName(), user.getEmail());
        if(userInDB != null) {
            throw  new ResourceAlreadyExistsException(User.class);
        }
        return userRepository.save(user);
    }

    /**
     * @return It will return a list with all the registered users
     */
    @Override
    public List<User> getUserList() {
        return userRepository.allUsers();
    }

    /**
     * @param id The user id to search for
     * @return It will return the User with the provided id
     * @throws ResourceNotFoundException In case that there is not a registered user with the provided id
     */
    @Override
    public User findUserById(long id) throws ResourceNotFoundException {
        User foundUser = userRepository.findById(id);
        if(foundUser == null) {
            throw new ResourceNotFoundException(User.class, id);
        }
        return foundUser;
    }

    /**
     * @param userIdToUpdate The user id to update
     * @param dataToUpdate The data to modify in the User entity
     * @param requestUserId The user that request the update
     * @return It will return the updated user
     * @throws UnauthorizedException In case that user that request the update is not the user to be updated
     * @throws ResourceNotFoundException In case that there is not a registered user with the provided id
     */
    @Override
    public User updateUserInfo(long userIdToUpdate, UserDTO dataToUpdate, long requestUserId)
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
