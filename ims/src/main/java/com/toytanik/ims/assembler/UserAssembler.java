package com.toytanik.ims.assembler;

import com.toytanik.ims.model.User;
import com.toytanik.ims.model.UserRequest;
import com.toytanik.ims.model.UserResponse;

public class UserAssembler {
    public User writeEntity(UserRequest userRequest) {
        User user = new User();

        user.setName(userRequest.getName().toLowerCase());
        user.setSurname(userRequest.getSurname().toLowerCase());
        user.setEmail(userRequest.getEmail().toLowerCase());

        return user;
    }

    public static UserResponse writeRegistrationResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        userResponse.setEmail(user.getSurname());
        return userResponse;
    }

    public User patchUser(User user, UserRequest userRequest) {

        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setEmail(userRequest.getEmail());

        return user;
    }
}
