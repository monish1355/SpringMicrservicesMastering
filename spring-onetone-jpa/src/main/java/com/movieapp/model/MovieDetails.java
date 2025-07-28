package com.movieapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MovieDetails {
	
	@Id
	@GeneratedValue(generator = "moviedetails_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "moviedetails_gen",sequenceName = "moviedetails_seq",initialValue=1)
	private Long id;
	
	@Column(length = 50)
	private String synopsis;
    private double budget;
    private int  durationInMinutes;

}
