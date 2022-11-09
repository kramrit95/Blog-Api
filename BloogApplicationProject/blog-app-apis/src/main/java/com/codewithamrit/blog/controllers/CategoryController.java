package com.codewithamrit.blog.controllers;

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

import com.codewithamrit.blog.payloads.ApiResponse;
import com.codewithamrit.blog.payloads.CategoryDto;

import com.codewithamrit.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	
	// Post-create category
	
		@Autowired
		private CategoryService categoryService;

		@PostMapping("/")
		public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
			CategoryDto createCategoryDto = this.categoryService.createCategory(categoryDto);
			return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);

		}

		// put update category
		@PutMapping("/{categoryId}")
		public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable("categoryId") Integer categoryId) {
			CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, categoryId);
			return ResponseEntity.ok(updatedCategory);
		}

		// Delete delete category

		@DeleteMapping("/{categoryId}")
		public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
			this.categoryService.deleteCategory(categoryId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted succesfully", true), HttpStatus.OK);
		}

		// Get all category
		@GetMapping("/")
		public ResponseEntity<List<CategoryDto>> getAllCategory() {
			return ResponseEntity.ok(this.categoryService.getAllCategory());

		}

		// Get single category get
		@GetMapping("/{categoryId}")
		public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable("categoryId") Integer categoryId) {
			return ResponseEntity.ok(this.categoryService.getCategoryById(categoryId));

		}

}
