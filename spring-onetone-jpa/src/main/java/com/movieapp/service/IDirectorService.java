package com.movieapp.service;

import com.movieapp.model.DirectorDto;

public interface IDirectorService {
    DirectorDto addDirector(DirectorDto directorDto);
    DirectorDto getDirectorById(Long id);
    
}
