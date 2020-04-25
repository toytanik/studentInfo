package com.toytanik.ims.service;

import com.toytanik.ims.model.UserRequest;
import com.toytanik.ims.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    UserRequest userRequest;

    @BeforeEach
    public void setup(){
        userRequest = new UserRequest();
        userRequest.setName("tuncay");
        userRequest.setSurname("turk");
        userRequest.setEmail("tuncayturk.cse@gmail.com");

    }

    @Test
    public void shouldCreateNewUserWithUniqueEmail(){

        userService.createUser(userRequest);

        assertEquals("tuncay", userRequest.getName());


    }

    @Test
    public void shouldNotCreateNewUserWithExistEmail(){

    }

    @Test
    public void shouldReturnAllUser(){

    }

    @Test
    public void shouldReturnOneUserWithIdIfItExist(){

    }

    @Test
    public void shouldDeleteUserWithIdIfItExist(){

    }

    @Test
    public void shouldUpdateUserWithIdIfItExist(){

    }

}
