package com.recipes.Services;

import com.recipes.DTO.UserDTO;
import com.recipes.Entities.User;
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
        /*if(!user.hasAllParameters()) {
            throw new IllegalArgumentException("All the parameters must not be nulls or empties");
        }
        user.setId(generateId());
        userList.add(user);*/
    }

    @Override
    public List<UserDTO> getUserList() {
        return Factory.toUserDTOList(userRepository.allUsers());
    }

    @Override
    public UserDTO findUserbyId(int id) {
        User foundUser = userRepository.findById(id);
        if(foundUser != null) {
            return Factory.toUserDTO(foundUser);
        }
        return null;
    }

    @Override
    public UserDTO updateUserInfo(int id, UserDTO dataToUpdate, int userId) {
        UserDTO foundedUserDTO = null;
        /*int index = userList.size();
        if(id < 0) {
            throw new IllegalArgumentException("Negative id is not valid");
        }

        while(foundedUserDTO == null && --index >= 0) {
            foundedUserDTO = (userList.get(index).hasId(id)) ? userList.get(index) : null;
        }

        if(foundedUserDTO == null) {
            throw new ResourceNotFoundException(UserDTO.class, id);
        }

        if(!foundedUserDTO.hasId(userId)) {
            throw new UnauthorizedException();
        }

        foundedUserDTO.updateInfo(dataToUpdate);*/
        return foundedUserDTO;
    }

    private int generateId() {
        /*if(userList.size() == 0) {
            return 1;
        } else {
            return userList.get(userList.size() - 1).getId() + 1;
        }*/
        return 0;
    }
}
