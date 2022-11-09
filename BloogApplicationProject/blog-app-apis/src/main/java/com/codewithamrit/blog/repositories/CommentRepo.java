package com.codewithamrit.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithamrit.blog.model.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
