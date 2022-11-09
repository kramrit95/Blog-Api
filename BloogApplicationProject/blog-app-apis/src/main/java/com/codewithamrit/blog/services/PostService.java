package com.codewithamrit.blog.services;

import java.util.List;

import com.codewithamrit.blog.model.Post;
import com.codewithamrit.blog.payloads.PostDto;
import com.codewithamrit.blog.payloads.PostResponse;

public interface PostService {

	// create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	// update
	PostDto updatePost(PostDto postDto, Integer userId);// fun(newdata,olduserid)

	// get all post by id

	PostDto getPostById(Integer postId);

	// get all post
	PostResponse getAllposts(Integer pageNumber, Integer PageSize, String sortBy, String sortDir);

	// delete post
	void deletePost(Integer postId);

	// get post by category
	List<PostDto> getPostsByCategory(Integer categoryId);

	// get all post by user
	List<PostDto> getPostsByUser(Integer userId);

	// search post
	List<PostDto> serchPosts(String keyword);

}
