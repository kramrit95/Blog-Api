package com.codewithamrit.blog.payloads;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
public class JwtAuthResponse {
	
	private String token;

}
