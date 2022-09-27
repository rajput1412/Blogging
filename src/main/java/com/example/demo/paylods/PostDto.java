package com.example.demo.paylods;

import java.util.Date;

import com.example.demo.entity.Category;
import com.example.demo.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
	
	private Integer id;
	
	private String title;
	
	private String content;
	
	private Date postDate;
	
	private String imagename;
	
	private UserDto user;
	
	private CategoryDto category;

}
