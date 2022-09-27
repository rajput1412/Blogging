package com.example.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.User;
import com.example.demo.paylods.CategoryDto;
import com.example.demo.paylods.UserDto;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.services.ICategoryService;

@Service
public class CategoryServiceImpl  implements ICategoryService{
	
	@Autowired
	private ModelMapper modelMapper;
 

	@Autowired
	private ICategoryRepository icategoryrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	
	public CategoryDto createCategory(CategoryDto categorydto) {
		Category user=this.dtoToCategory(categorydto);
		Category saveuser=this.icategoryrepo.save(user);
		return this.categoryToCategoryDto(saveuser);
		
		// TODO Auto-generated method stub
//		Category cat= this.modelmapper.map(categorydto,Category.class );
//		Category addedcat= this.icategoryrepo.save(cat);
//		return this.modelmapper.map(addedcat, CategoryDto.class);
	}

	
	public CategoryDto updateCategory(CategoryDto cateorydto, Integer categoryId) {
		
		
		Category user=this.icategoryrepo.findById(categoryId).get();	
		
		user.setCategoryTitle(cateorydto.getCategoryTitle());
		user.setCategoryDescription(cateorydto.getCategoryDescription());
		Category updateduser=this.icategoryrepo.save(user);
		return  this.categoryToCategoryDto(updateduser);
		
		
//		Category cat=this.icategoryrepo.findById(categoryId).get();
//		cat.setCategoryTitle(cateorydto.getCategoryTitle());
//		cat.setCategoryDescription(cateorydto.getCategoryDescription());
//		Category cats=icategoryrepo.save(cat);
//		return this.modelmapper.map(cats,CategoryDto.class);
	}

	
	public void delleteCategory(Integer categoryId) {
		Category cat=this.icategoryrepo.findById(categoryId).get();
		this.icategoryrepo.delete(cat);
		
	}

	
	public CategoryDto getCategory(Integer categoryId) {
		Category user=this.icategoryrepo.findById(categoryId).get();		
		return this.categoryToCategoryDto(user);
	}

	
	public List<CategoryDto> getAllCategory() {

//		List<Category>users= this.icategoryrepo.findAll();
//		List<CategoryDto>userDto=users.stream().map((user)->this.categoryToCategoryDto(users)).collect(Collectors.toList());
//		return userDto;
		List<Category>categories=this.icategoryrepo.findAll();
		List<CategoryDto>categori=categories.stream().map((cat)->this.modelmapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return categori;
	}
	
	public Category dtoToCategory(CategoryDto categoryDto)
	{
		Category user=this.modelMapper.map(categoryDto, Category.class);
		return user;
	}
	
	public CategoryDto categoryToCategoryDto(Category user) {
		CategoryDto userDto=this.modelMapper.map(user,CategoryDto.class);
		return userDto;
	}

	
	
	
	
}
