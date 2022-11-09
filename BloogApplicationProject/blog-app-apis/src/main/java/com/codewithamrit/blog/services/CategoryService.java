package com.codewithamrit.blog.services;

import java.util.List;

import com.codewithamrit.blog.payloads.CategoryDto;
//for loose coupling

public interface CategoryService {
	CategoryDto	createCategory(CategoryDto  categoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	CategoryDto getCategoryById(Integer categoryId);
	List<CategoryDto> getAllCategory();
	void deleteCategory(Integer categoryId);



}
