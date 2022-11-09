package com.codewithamrit.blog.services;

import com.codewithamrit.blog.payloads.CommentDto;

public interface CommentService {
	
	
CommentDto createComment(CommentDto commentDto,Integer postId);
void deleteComment(Integer commentId);
//we also make update as you depend
}
