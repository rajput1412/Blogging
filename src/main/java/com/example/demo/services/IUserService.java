package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.paylods.UserDto;
public interface IUserService {
	
	 UserDto createUser(UserDto user);
	
	 UserDto updateUser(UserDto user,Integer userId);
	 
	 UserDto getUserById(Integer userId) ;
	 
	 List<UserDto>getAllUsers();
	 
	 void delleteUser(Integer userId);

}
