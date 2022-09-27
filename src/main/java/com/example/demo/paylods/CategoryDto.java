package com.example.demo.paylods;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Validated
public class CategoryDto {
	
	private Integer categoryId;
	@NotEmpty
	@Size(min=4,message="UserName must be grater than 4 character")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min=4,message="categoryDescription  must be grater than 4 character")
	private String categoryDescription;

}
