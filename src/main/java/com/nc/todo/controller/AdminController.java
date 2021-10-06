package com.nc.todo.controller;

import com.okta.sdk.client.Client;
import com.okta.sdk.resource.user.User;
import com.okta.sdk.resource.user.UserBuilder;
import com.okta.sdk.resource.user.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private Client client;

    @GetMapping("/users")
    public UserList getUsers() {
        return client.listUsers();
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody com.nc.todo.entity.User reqBodyUser) {
        char[] tempPassword = {'P','a','$','$','w','0','r','d'};
        User user = UserBuilder.instance()
                .setEmail(reqBodyUser.getEmail())
                .setFirstName(reqBodyUser.getFirstName())
                .setLastName(reqBodyUser.getLastName())
                .setPassword(tempPassword)
                .setActive(true)
                .buildAndCreate(client);
        return user;
    }

}
