package com.codewithamrit.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithamrit.blog.model.Category;


public interface CategoryRepo extends JpaRepository<Category,Integer> {


}
