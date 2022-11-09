package com.codewithamrit.blog.services;

import java.util.List;



import com.codewithamrit.blog.payloads.UserDto;
public interface UserService {
	UserDto registerNewUser(UserDto user);
	
	
UserDto	createUser(UserDto user);
UserDto updateUser(UserDto user,Integer userId);//fun(newdata,olduserid)
UserDto getUserById(Integer userId);
List<UserDto> getAllUsers();
void delete(Integer userId);


}
