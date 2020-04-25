package com.toytanik.ims.service;

import com.toytanik.ims.ImsErrorCode;
import com.toytanik.ims.exceptions.ImsExceptions;
import com.toytanik.ims.model.User;
import com.toytanik.ims.model.UserRequest;
import com.toytanik.ims.model.UserResponse;
import com.toytanik.ims.repository.UserRepository;
import com.toytanik.ims.assembler.UserAssembler;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    @SneakyThrows
    public UserResponse createUser(UserRequest userRequest) {
        UserAssembler userAssembler = new UserAssembler();
        User user = userAssembler.writeEntity(userRequest);
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new ImsExceptions(ImsErrorCode.EMAIL_ALREADY_EXIST);
        }
        userRepository.save(user);

        return userAssembler.writeRegistrationResponse(user);
    }

    public List<UserResponse> getUsers() {
        List<UserResponse> userResponse = new ArrayList<>();
        Iterator<User> user = userRepository.findAll().iterator();
        while (user.hasNext()) {
            User userr = user.next();
            userResponse.add(UserAssembler.writeRegistrationResponse(userr));
        }
        return userResponse;
    }

    public UserResponse getUsers(Long id) {
        UserAssembler userAssembler = new UserAssembler();
        User user = userRepository.findAllById(id);

        return  userAssembler.writeRegistrationResponse(user);
    }
    public UserResponse updateUser(UserRequest userRequest, Long id) {
        UserAssembler userAssembler = new UserAssembler();
        User user = userRepository.findAllById(id);
        User userbeUpdate = userAssembler.patchUser(user,userRequest);

        userRepository.save(userbeUpdate);

        return userAssembler.writeRegistrationResponse(userbeUpdate);
    }
    public UserResponse deleteUser(Long id) {
        UserAssembler userAssembler = new UserAssembler();
        User user = userRepository.findAllById(id);
        userRepository.delete(user);

        return userAssembler.writeRegistrationResponse(user);
    }
}
