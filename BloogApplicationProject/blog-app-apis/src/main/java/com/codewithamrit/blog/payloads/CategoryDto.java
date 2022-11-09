package com.codewithamrit.blog.payloads;





import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor

public class CategoryDto {
	
	
	
		
		
		private Integer categoryId;
		@NotEmpty
		@NotBlank
		@Size(min=4,message="min size of category title is 4")
		private String categoryTitle;
		@NotEmpty
		@NotBlank
		@Size(min=10,message="min size of category title is 4")
		private String categoryDescription;


	

}
