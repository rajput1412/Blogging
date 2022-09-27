package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.paylods.PostDto;
import com.example.demo.paylods.PostResponse;

public interface PostService {
	

	PostDto createPost(PostDto post,Integer userId,Integer categoryId);
	
	PostDto updatePost(PostDto post, Integer postId);
	
	PostDto getPostById(Integer postId);
	
	void delletePost(Integer postId);
	
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy);
	
	List<PostDto>getPostByCategory(Integer categoryId);
	
	List<PostDto>getPostByUserId(Integer userId);
	
	List<PostDto>searchPost(String keyword);
	
}
