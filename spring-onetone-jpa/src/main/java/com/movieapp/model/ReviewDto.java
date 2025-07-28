package com.movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewDto {

	
	 private Long id;
     private int rating;
     private String comment;
     private Long movieId;
}
