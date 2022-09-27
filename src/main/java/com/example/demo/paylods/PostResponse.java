package com.example.demo.paylods;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostResponse {
	
	
	private List<PostDto> content;
	
	private Integer pageNumber;
	
	private Integer pageSize;
	
	private Long totalElements;
	
	private int totalPage;
	
	private boolean lastPage;

}
