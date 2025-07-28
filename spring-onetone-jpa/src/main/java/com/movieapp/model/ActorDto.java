package com.movieapp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActorDto {

	private Long actorId;
	
	private String name;
	private List<Long> movieIds; 
	
	
}
