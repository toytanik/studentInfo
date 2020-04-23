package com.toytanik.ims.controller;

import com.toytanik.ims.model.UserRequest;
import com.toytanik.ims.model.UserResponse;
import com.toytanik.ims.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService ;


    @PostMapping("/")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.createUser(userRequest);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> getUser(){
        List<UserResponse> userResponse = userService.getUsers();
        return  ResponseEntity.ok(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse>  getUsers(@PathVariable Long id) {
        UserResponse userResponse = userService.getUsers(id);
        return ResponseEntity.ok(userResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest, @PathVariable Long id) {
        UserResponse userResponse = userService.updateUser(userRequest, id);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id) {
        UserResponse userResponse = userService.deleteUser(id);
        return ResponseEntity.ok(userResponse);
    }

}
