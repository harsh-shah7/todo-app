package com.nc.todo.serviceimpl;

import com.nc.todo.dto.UserDto;
import com.nc.todo.entity.User;
import com.nc.todo.exception.UserNotFoundException;
import com.nc.todo.repository.UserRepository;
import com.nc.todo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public UserDto getUser(Long id) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return prepareUserDto(optionalUser.get());
        }
        else{
            throw new UserNotFoundException();
        }
    }

    private UserDto prepareUserDto(User user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos =new ArrayList<>();
        if(!CollectionUtils.isEmpty(users)){
            userDtos.addAll(users.stream().map(user -> prepareUserDto(user)).collect(Collectors.toList()));
        }
        return userDtos;
    }

    public UserDto createUser(User user){
        return prepareUserDto(userRepository.save(user));
    }
}
