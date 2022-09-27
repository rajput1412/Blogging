package com.example.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.paylods.UserDto;
import com.example.demo.repository.IUserRepostiroy;
import com.example.demo.services.IUserService;
@Service
public class UserServiceImpl implements IUserService  {
	
	@Autowired
	private IUserRepostiroy iUserRepostiroy;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userdto) {
		User user=this.dtoToUser(userdto);
		User saveuser=this.iUserRepostiroy.save(user);
		return this.userToUserDto(saveuser);
	}

	@Override
	public UserDto updateUser(UserDto userdto, Integer userId) {
		
		User user=this.iUserRepostiroy.findById(userId).get();	
		
		user.setName(userdto.getUserName());
		user.setPassword(userdto.getUserPassword());
		user.setEmail(userdto.getEmail());
		user.setAbout(userdto.getAbout());
		User updateduser=this.iUserRepostiroy.save(user);
		return  this.userToUserDto(updateduser);
	}

	@Override
	public UserDto getUserById(Integer userId)  {
		User user=this.iUserRepostiroy.findById(userId).get();		
			return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User>users= this.iUserRepostiroy.findAll();
		List<UserDto>userDto=users.stream().map(user->this.userToUserDto(user)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void delleteUser(Integer userId) {
			User user=iUserRepostiroy.findById(userId).get();
			this.iUserRepostiroy.delete(user);
	}
	
	public User dtoToUser(UserDto userDto)
	{
		User user=this.modelMapper.map(userDto, User.class);
		
//		user.setName(userDto.getUserName());
//		user.setUserId(userDto.getUserId());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getUserPassword());
		return user;
	}
	
	public UserDto userToUserDto(User user) {
		
		UserDto userDto=this.modelMapper.map(user,UserDto.class);
		
		
//		userDto.setUserId(user.getUserId());
//		userDto.setUserName(user.getName());
//		userDto.setUserPassword(user.getPassword());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
		return userDto;
	}

}
