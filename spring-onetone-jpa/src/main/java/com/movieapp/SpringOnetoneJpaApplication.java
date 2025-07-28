package com.movieapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movieapp.model.ActorDto;
import com.movieapp.model.MovieDto;
import com.movieapp.service.ActorService;
import com.movieapp.service.IDirectorService;
import com.movieapp.service.IMovieService;

@SpringBootApplication
public class SpringOnetoneJpaApplication implements CommandLineRunner	{

	public static void main(String[] args) {
		SpringApplication.run(SpringOnetoneJpaApplication.class, args);
	}

	@Autowired
	private IMovieService movieService;
	
	@Autowired
	private IDirectorService directorService;
	
	@Autowired
	private ActorService actorService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		MovieDetailsDto movieDetailsDto = new MovieDetailsDto(null,"Romantic",200000000,
//			    170);
//		
//		MovieDto movieDto = new MovieDto(null, "Premam",2015,
//			    "Malayalam",
//			    "IMAX",
//			    "Romance",
//			    movieDetailsDto);
//		movieService.saveMovie(movieDto);
//		
		// add reviews
//		ReviewDto review1 = new ReviewDto();
//	    review1.setRating(9);
//	    review1.setComment("Classic love story");
//	    review1.setMovieId(201L);
//	    movieService.addReviewToMovie(review1);
//
//	    // Add a second review
//	    ReviewDto review2 = new ReviewDto();
//	    review2.setRating(8);
//	    review2.setComment("Soulful Music and visuals");
//	    review2.setMovieId(201L);
//	    movieService.addReviewToMovie(review2);
//
//	    // Fetch and print them back
//	    System.out.println("\n--- Reviews for movie " + " ---");
//	    movieService.getReviewsForMovie(201L)
//	                .forEach(System.out::println);
//		

//		System.out.println();
//		System.out.println(" get job synopsis  and duration");
//		movieService.getBysynopsisduration("Romantic",170).forEach(System.out::println);
//		
	    
	    
	    
	    ///director
	    
	 // 1. Add a director
//	    DirectorDto directorDto = new DirectorDto(null, "Gautham Vasudev Menon");
//	    directorDto = directorService.addDirector(directorDto);
//	    
		
		//MovieDto updatedMovie = movieService.assignDirectorToMovie(100L, 1L);

		
		//Add a actors to movie
//		 ActorDto actorDto = new ActorDto();
//		    actorDto.setName("Simbu STR");
//		    ActorDto savedActor = actorService.addActor(actorDto);
//
//		    
//		    Long movieId = 100L; 
//		    MovieDto updatedMovie = actorService.assignActorToMovie(movieId, savedActor.getActorId());

		    //System.out.println("Assigned actor to movie: " + updatedMovie.getTitle());
	}

}
