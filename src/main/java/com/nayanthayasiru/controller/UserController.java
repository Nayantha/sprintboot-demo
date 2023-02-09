package com.nayanthayasiru.controller;

import com.nayanthayasiru.exception.ResourceNotFoundException;
import com.nayanthayasiru.model.User;
import com.nayanthayasiru.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("No employee found to the given user id: " + id)
        );
        return ResponseEntity.ok(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User editedUser){
        User userToUpdate = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("No employee found to the given user id: " + id)
        );

        userToUpdate.setFirstName(editedUser.getFirstName());
        userToUpdate.setLastName(editedUser.getLastName());
        userToUpdate.setEmailId(editedUser.getEmailId());

        userRepository.save(userToUpdate);

        return ResponseEntity.ok(userToUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("No employee found to the given user id: " + id)
        );
        userRepository.delete(user);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
