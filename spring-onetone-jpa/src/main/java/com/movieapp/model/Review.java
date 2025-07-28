package com.movieapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Review {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rating;          
    @Column(length = 1000)
    private String comment;

    // Many reviews → one movie
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
	
}
