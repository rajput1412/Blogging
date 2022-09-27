package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Post;
import com.example.demo.paylods.CategoryDto;
import com.example.demo.paylods.PostDto;
import com.example.demo.paylods.PostResponse;
import com.example.demo.paylods.UserResponse;
import com.example.demo.services.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
	
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userId}/category/{categoryId}")
	public ResponseEntity<PostDto>createPost(@RequestBody PostDto postdto,@PathVariable Integer userId,@PathVariable Integer categoryId )
	{
	PostDto post =this.postService.createPost(postdto, userId, categoryId);
		
		return new ResponseEntity<PostDto>(post,HttpStatus.CREATED);
		
	}

	
	@GetMapping("/user/{userId}/post")
	public ResponseEntity<List<PostDto>>getAllPostByUser(@PathVariable Integer userId)
	{
		List<PostDto>posts=this.postService.getPostByUserId(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}/post")
	public ResponseEntity<List<PostDto>>getAllPostByCategory(@PathVariable Integer categoryId)
	{
		List<PostDto>posts=this.postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/post")
	public ResponseEntity<PostResponse>getAllPost(@RequestParam(value="pageNumber",defaultValue="0",required = false)Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue="10",required = false) Integer pageSize,
			@RequestParam(value="sortBy",defaultValue="id",required=false)String sortBy
			
			)
	{
		PostResponse post =this.postService.getAllPost(pageNumber,pageSize,sortBy);
		return new ResponseEntity<PostResponse>(post,HttpStatus.OK);
	}
	
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto>getPostById(@PathVariable Integer postId)
	{
		PostDto post=this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(post,HttpStatus.OK);
	}
	
	
	@PutMapping("postupdate/{postId}")
	public ResponseEntity<PostDto> updatePost( @Valid @RequestBody PostDto postDto,@PathVariable Integer postId)
	{
		PostDto postDto1=this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(postDto1,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/delletepost/{postId}")
	public ResponseEntity<?>delletePost(@PathVariable Integer postId)
	{
		this.postService.delletePost(postId);
		return new ResponseEntity<UserResponse>(new UserResponse("Post is  Delleted Succesfuly",true),HttpStatus.OK);
		
	//	return new ResponseEntity<>(Map.of("message:","User Dellete Succefully"), HttpStatus.OK);
	}
	}
