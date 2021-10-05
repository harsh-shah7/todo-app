package com.nc.todo.controller;

import com.nc.todo.entity.User;
import com.nc.todo.exception.UserNotFoundException;
import com.nc.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        try {
            return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    //@PreAuthorize("hasAuthority('Admin')")
    @GetMapping("")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    //@PreAuthorize("hasAuthority('Admin')")
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return new ResponseEntity(userService.createUser(user),HttpStatus.CREATED);
    }
}
