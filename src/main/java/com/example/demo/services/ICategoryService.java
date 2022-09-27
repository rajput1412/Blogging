package com.example.demo.services;

import java.util.List;

import com.example.demo.paylods.CategoryDto;

public interface ICategoryService {
	
	public CategoryDto createCategory(CategoryDto categorydto);
	
	public CategoryDto updateCategory(CategoryDto cateorydto,Integer categoryId);
	
	public void delleteCategory(Integer categoryId);
	
	public CategoryDto getCategory(Integer categoryId);
	
	public List<CategoryDto>getAllCategory();
	

}
