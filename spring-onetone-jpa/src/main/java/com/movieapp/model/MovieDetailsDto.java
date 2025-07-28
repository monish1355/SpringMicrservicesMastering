	package com.movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
	@AllArgsConstructor
	@Data
public class MovieDetailsDto {

	
	private Long id;
	
	private String synopsis;
    private double budget;
    private int  durationInMinutes;
}
