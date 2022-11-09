package com.codewithamrit.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithamrit.blog.exceptions.ResourceNotFoundException;
import com.codewithamrit.blog.model.Category;

import com.codewithamrit.blog.payloads.CategoryDto;

import com.codewithamrit.blog.repositories.CategoryRepo;
import com.codewithamrit.blog.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category category = this.dtoToCategory(categoryDto);

		Category saveCategory = this.categoryRepo.save(category);

		return this.categoryToDto(saveCategory);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());

		Category updateCategory = this.categoryRepo.save(category);
		CategoryDto categoryDto1 = this.categoryToDto(updateCategory);
		return categoryDto1;

	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
		return this.categoryToDto(category);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categorys = this.categoryRepo.findAll();
		// lamda fx use for convert list
		List<CategoryDto> categoryDtos = categorys.stream().map(category -> this.categoryToDto(category))
				.collect(Collectors.toList());
		;
		return categoryDtos;

	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", " category id", categoryId));
		this.categoryRepo.delete(category);

	}

	private Category dtoToCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);

		return category;
	}

	private CategoryDto categoryToDto(Category category) {
		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);

		return categoryDto;

	}

}
