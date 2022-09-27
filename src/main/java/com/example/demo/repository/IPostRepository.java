package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.paylods.PostDto;

public interface IPostRepository  extends JpaRepository<Post, Integer> {
	
	List<Post>findByUser(User user);
	List<Post>findByCategory(Category category);
	
	//List<Post>findByTitleContain(String contain);
	
	
}
