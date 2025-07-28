
package com.movieapp.service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.model.Actor;
import com.movieapp.model.ActorDto;
import com.movieapp.model.Movie;
import com.movieapp.model.MovieDto;
import com.movieapp.repository.ActorRepository;
import com.movieapp.repository.IMovieRepository;

@Service

public class ActorServiceImpl implements ActorService {

	
	@Autowired
     ActorRepository actorRepository;
	@Autowired
     IMovieRepository movieRepository;
	@Autowired
     ModelMapper mapper;

    @Override
    public ActorDto addActor(ActorDto actorDto) {
        Actor actor = mapper.map(actorDto, Actor.class);
        actor = actorRepository.save(actor);
        return mapper.map(actor, ActorDto.class);
    }

    @Override
    public MovieDto assignActorToMovie(Long movieId, Long actorId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        Actor actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new RuntimeException("Actor not found"));

        movie.getActors().add(actor);
        actor.getMovies().add(movie); // optional, helps keep bidirectional in sync

        movieRepository.save(movie);

        return mapper.map(movie, MovieDto.class);
    }
}
