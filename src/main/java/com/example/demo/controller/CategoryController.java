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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.paylods.CategoryDto;
import com.example.demo.paylods.UserDto;
import com.example.demo.paylods.UserResponse;
import com.example.demo.services.ICategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private ICategoryService icategoryService;
	
	@PostMapping("/createCategory")
	public ResponseEntity<CategoryDto>createCategory(@Valid @RequestBody CategoryDto categoryDto)
	{
		CategoryDto categorydto=this.icategoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(categorydto,HttpStatus.CREATED);
		
	}
	
	@PutMapping("{cateoryId}")
	public ResponseEntity<CategoryDto>updateCategory( @Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer cateoryId)
	{
		CategoryDto categorydto=this.icategoryService.updateCategory(categoryDto, cateoryId);
		return new ResponseEntity<CategoryDto>(categorydto,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delleteUser/{categoryId}")
	public ResponseEntity<?>delltedUser(@PathVariable Integer categoryId)
	{
		this.icategoryService.delleteCategory(categoryId);
		return new ResponseEntity<UserResponse>(new UserResponse("Category Delleted Succesfuly",true),HttpStatus.OK);
		
	//	return new ResponseEntity<>(Map.of("message:","User Dellete Succefully"), HttpStatus.OK);
	}
	
	@GetMapping("/getAllCategory")
	public ResponseEntity<List<CategoryDto>>getCategory()
	{ List<CategoryDto>allcategory=this.icategoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(allcategory,HttpStatus.OK);
	}

	
	@GetMapping("/getCategory/{categoryId}")
	public ResponseEntity<CategoryDto>getUser(@PathVariable Integer categoryId)
	{
		return new ResponseEntity<CategoryDto>(this.icategoryService.getCategory(categoryId),HttpStatus.OK);
	}

	
	

}