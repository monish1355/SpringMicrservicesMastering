package com.movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDto {

private Long movieId;
	
	private String title;
	private int releaseYear;
	
	private String language;
	private String format;
	private String genre;
	private MovieDetailsDto details;
	private Long directorId;
	
}
