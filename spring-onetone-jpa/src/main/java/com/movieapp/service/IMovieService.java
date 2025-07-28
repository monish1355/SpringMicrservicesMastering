package com.movieapp.service;

import java.util.List;

import com.movieapp.model.DirectorDto;
import com.movieapp.model.MovieDto;
import com.movieapp.model.ReviewDto;

public interface IMovieService {
	
	void saveMovie(MovieDto movieDto);
	void updateMovie(MovieDto movieDto);
	void deleteMovie(Long movieId);
	MovieDto getMovieById(Long movieId);
    List<MovieDto> getAllMovies();
    List<MovieDto> getBysynopsisduration(String synopsis, int genre);
    
    ReviewDto addReviewToMovie(ReviewDto reviewDto);
    List<ReviewDto> getReviewsForMovie(Long movieId);
    MovieDto assignDirectorToMovie(Long movieId, Long directorId);
    
    MovieDto addActorToMovie(Long movieId, Long actorId);
}
