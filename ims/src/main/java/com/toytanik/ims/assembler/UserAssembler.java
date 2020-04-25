package com.toytanik.ims.assembler;

import com.toytanik.ims.model.User;
import com.toytanik.ims.model.UserRequest;
import com.toytanik.ims.model.UserResponse;
import com.toytanik.ims.validator.UserValidator;

public class UserAssembler {


    public User writeEntity(UserRequest userRequest) {
        User user = new User();
        UserValidator userValidator = new UserValidator();
        user.setName(UserValidator.checkUserName (userRequest.getName().toLowerCase())); //getSurname().toLowerCase()
        user.setSurname(UserValidator.checkUserSurname(userRequest.getSurname().toLowerCase()));
        user.setEmail(UserValidator.checkUserEmail(userRequest.getEmail().toLowerCase()));

        return user;
    }

    public static UserResponse writeRegistrationResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }

    public User patchUser(User user, UserRequest userRequest) {

        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setEmail(userRequest.getEmail());

        return user;
    }
}
