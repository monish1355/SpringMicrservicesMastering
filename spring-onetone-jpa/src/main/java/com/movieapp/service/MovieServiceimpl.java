package com.movieapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.Exception.MovieNotFoundException;
import com.movieapp.model.Actor;
import com.movieapp.model.Director;
import com.movieapp.model.Movie;
import com.movieapp.model.MovieDto;
import com.movieapp.model.Review;
import com.movieapp.model.ReviewDto;
import com.movieapp.repository.ActorRepository;
import com.movieapp.repository.DirectorRepository;
import com.movieapp.repository.IMovieRepository;
import com.movieapp.repository.ReviewRepository;


@Service

public class MovieServiceimpl implements IMovieService {

	@Autowired
	private IMovieRepository movieRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private DirectorRepository directorRepository;
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private ModelMapper mapper;
	@Override
	public void saveMovie(MovieDto movieDto) {
		Movie movie = mapper.map(movieDto, Movie.class);
		movieRepository.save(movie);
	}

	@Override
	public void updateMovie(MovieDto movieDto) {
		Movie movie = mapper.map(movieDto, Movie.class);
		movieRepository.save(movie);
	}

	@Override
	public void deleteMovie(Long movieId) {
		movieRepository.deleteById(movieId);
	}

	@Override
	public MovieDto getMovieById(Long movieId) {
		
		Movie movie = movieRepository.findById(movieId)
		        .orElseThrow(()-> new RuntimeException("Movie Not found"));
		return mapper.map(movie, MovieDto.class);
	}

	@Override
	public List<MovieDto> getAllMovies() {
		
		List<Movie> movies = movieRepository.findAll();
		return movies.stream()
				.map(movie->mapper.map(movie, MovieDto.class))
				.toList();
	}



	@Override
	public List<MovieDto> getBysynopsisduration(String synopsis, int durationInMinutes) {
		List<Movie> mdetails = movieRepository.findBysynopsistime(synopsis, durationInMinutes);
		if (mdetails.isEmpty())
			throw new MovieNotFoundException("invlaid  time and synopsis");
		return mdetails.stream().map((movie) -> mapper.map(movie, MovieDto.class)).toList();
	}
	
	
	/* -------------------------------------------------
    Add *one* review to an existing movie one to many reviews
 ------------------------------------------------- */

	@Override
	public ReviewDto addReviewToMovie(ReviewDto reviewDto) {
		Movie movie = movieRepository.findById(reviewDto.getMovieId())
				.orElseThrow(()-> new RuntimeException("Movie Not found"));
		Review review = mapper.map(reviewDto, Review.class);
		review.setMovie(movie);
		movie.getReviews().add(review);
		review = reviewRepository.save(review);
		
		ReviewDto saved = mapper.map(review, ReviewDto.class);
        saved.setMovieId(movie.getMovieId());
        return saved;
	}

	@Override
	public List<ReviewDto> getReviewsForMovie(Long movieId) {
		Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        return movie.getReviews().stream()
                .map(r -> {
                    ReviewDto dto = mapper.map(r, ReviewDto.class);
                    dto.setMovieId(movieId);
                    return dto;
                })
                .collect(Collectors.toList());
    }

	@Override
	public MovieDto assignDirectorToMovie(Long movieId, Long directorId) {
	    Movie movie = movieRepository.findById(movieId)
	        .orElseThrow(() -> new RuntimeException("Movie not found"));
	    
	    Director director = directorRepository.findById(directorId)
	        .orElseThrow(() -> new RuntimeException("Director not found"));

	    movie.setDirector(director);
	    Movie updated = movieRepository.save(movie);

	    return mapper.map(updated, MovieDto.class);
	}

	

	@Override
	public MovieDto addActorToMovie(Long movieId, Long actorId) {
	    Movie movie = movieRepository.findById(movieId)
	        .orElseThrow(() -> new RuntimeException("Movie not found"));

	    Actor actor = actorRepository.findById(actorId)
	        .orElseThrow(() -> new RuntimeException("Actor not found"));

	    movie.getActors().add(actor); // Add actor to movie
	    movie = movieRepository.save(movie);

	    return mapper.map(movie, MovieDto.class);
	}


}
