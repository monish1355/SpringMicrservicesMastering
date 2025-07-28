package com.movieapp.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Movie {

	@Id
	@GeneratedValue(generator = "movie_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "movie_gen",sequenceName = "movie_seq",initialValue=100)
	private Long movieId;
	
	@Column(length = 25)
	private String title;
	private int releaseYear;
	
	@Column(length = 20)
	private String language;
	@Column(length = 20)
	private String format;
	@Column(length = 20)
	private String genre;
	
//	---------- Relationships ---------- 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "moviedt_id")
	private MovieDetails details;
	
	// One movie → many reviews
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true ,fetch = FetchType.EAGER)
    private List<Review> reviews = new ArrayList<>();
    
 // Many movies → one director
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private Director director;
    
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "movie_actor",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors = new ArrayList<>();
    
}
