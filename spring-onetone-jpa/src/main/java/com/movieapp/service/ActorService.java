package com.movieapp.service;

import com.movieapp.model.ActorDto;
import com.movieapp.model.MovieDto;

public interface ActorService {
    ActorDto addActor(ActorDto actorDto);
    MovieDto assignActorToMovie(Long movieId, Long actorId);
}
