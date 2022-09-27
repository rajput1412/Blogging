package com.example.demo.paylods;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Validated
public class UserDto {
	
	
	private int userId;
	
	@NotEmpty
	@Size(min=4,message="UserName must be grater than 4 character")
	private String userName;
	
	@NotEmpty
	@Size(min=4,max=10,message="Password Shuld be grater than  4 character and less than 10")
	private String userPassword;
	
	@Email(message="Email address is not valid!")
	private String email;
	
	@NotEmpty
	private String about;
	

}
