package com.codewithamrit.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.codewithamrit.blog.model.Category;
import com.codewithamrit.blog.model.Post;
import com.codewithamrit.blog.model.User;

public interface PostRepo extends JpaRepository<Post,Integer> {

List<Post> findByUser(User  user);//to get user post
List<Post> findByCategory(Category category);//a/q to category we get post
@Query("select p from Post p where p.title like :key")
List<Post> searchByTitle(@Param("key") String title);


}
