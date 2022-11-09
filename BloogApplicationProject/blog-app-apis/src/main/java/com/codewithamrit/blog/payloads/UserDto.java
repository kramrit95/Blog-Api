package com.codewithamrit.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {//data store that transfer

	private  int id;
	@NotEmpty
	@Size(min=4,message="Username must be min 4 chrracter")
	private String name;
	@Email(message="email addresis not valid")
	private String email;
	@NotEmpty
	@Size(min=3,max=10,message="min 3 and max 10")
	//@Pattern(regexp = "")
	private String password;
	@NotEmpty
	private String about;
	private Set<RoleDto> roles= new HashSet<>();
	
	
	

}
