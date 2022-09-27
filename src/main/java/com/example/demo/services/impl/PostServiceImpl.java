package com.example.demo.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.paylods.PostDto;
import com.example.demo.paylods.PostResponse;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.repository.IPostRepository;
import com.example.demo.repository.IUserRepostiroy;
import com.example.demo.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private IPostRepository postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IUserRepostiroy iuserRepo;
	
	@Autowired
	private ICategoryRepository icategoryRepo;
	
	
	@Override
	public PostDto createPost(PostDto post,Integer userId,Integer categoryid) {
		
		User user=iuserRepo.findById(userId).get();
		Category cate=icategoryRepo.findById(categoryid).get();
		
		Post posts=this.modelMapper.map(post, Post.class);
		posts.setImagename("default.jpg");
		posts.setPostdate(new Date());
		posts.setCategory(cate);
		posts.setUser(user);
		Post newpost=this.postRepo.save(posts);
		return  this.modelMapper.map(newpost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto post, Integer postId) {
		
		Post posts=this.postRepo.findById(postId).get();
		posts.setTitle(post.getTitle());
		posts.setImagename(post.getImagename());
	Post post1=	this.postRepo.save(posts);
		return this.modelMapper.map(post1, PostDto.class);
		
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post posts=this.postRepo.findById(postId).get();
		return this.modelMapper.map(posts, PostDto.class);
	}

	@Override
	public void delletePost(Integer postId) {
		
		Post pos=this.postRepo.findById(postId).get();
		this.postRepo.delete(pos);
	}

	@Override
	public PostResponse getAllPost(Integer pagenumber,Integer pagesize,String sortBy) {
		
		Pageable p=PageRequest.of(pagenumber, pagesize,Sort.by(sortBy).descending());
		Page<Post> posts= this.postRepo.findAll(p);
		List<Post>allPost=posts.getContent();
		List<PostDto>postd=allPost.stream().map((post)->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postresponse=new PostResponse();
		postresponse.setContent(postd);
		postresponse.setPageNumber(posts.getNumber());
		postresponse.setPageSize(posts.getSize());
		postresponse.setTotalElements(posts.getTotalElements());
		postresponse.setTotalPage(posts.getTotalPages());
		postresponse.setLastPage(posts.isLast());
		return postresponse;
	}
	
	

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		
		Category cat=this.icategoryRepo.findById(categoryId).get();
		List<Post> posts=	this.postRepo.findByCategory(cat);
		  List<PostDto>postd=posts.stream().map((post)->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postd;
	}

	@Override
	public List<PostDto> getPostByUserId(Integer userId)
	{
		User cat=this.iuserRepo.findById(userId).get();
		List<Post> posts=	this.postRepo.findByUser(cat);
		  List<PostDto>postd=posts.stream().map((post)->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postd;
		
		
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
