package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.paylods.UserDto;
import com.example.demo.paylods.UserResponse;
import com.example.demo.services.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	
	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser( @Valid @RequestBody UserDto userdto) {
		
		UserDto userd=this.userService.createUser(userdto);
		return new ResponseEntity<>(userd,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserDto>updateUser(@Valid @RequestBody UserDto userdto,@PathVariable Integer userId)
	{
		UserDto updateduser=this.userService.updateUser(userdto, userId);
		return  ResponseEntity.ok(updateduser);
	}
	
	@DeleteMapping("/delleteUser/{userId}")
	public ResponseEntity<?>delltedUser(@PathVariable Integer userId)
	{
		this.userService.delleteUser(userId);
		return new ResponseEntity<UserResponse>(new UserResponse("User Delleted Succesfuly",true),HttpStatus.OK);
		
	//	return new ResponseEntity<>(Map.of("message:","User Dellete Succefully"), HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserDto>>getUser()
	{
		
		 List<UserDto>allusers=this. userService.getAllUsers();
		 return new ResponseEntity<List<UserDto>>(allusers,HttpStatus.OK);
	}

	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserDto>getUser(@PathVariable Integer userId)
	{
		return new ResponseEntity<UserDto>(this.userService.getUserById(userId),HttpStatus.OK);
	}
	
	
}
