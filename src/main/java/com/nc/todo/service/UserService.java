package com.nc.todo.service;

import com.nc.todo.dto.UserDto;
import com.nc.todo.entity.User;
import com.nc.todo.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public UserDto getUser(Long id) throws UserNotFoundException;
    public List<UserDto> getAllUsers();
    public UserDto createUser(User user);
}
