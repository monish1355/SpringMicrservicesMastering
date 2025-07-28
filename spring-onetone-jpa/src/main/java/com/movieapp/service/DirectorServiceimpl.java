package com.movieapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.model.Director;
import com.movieapp.model.DirectorDto;
import com.movieapp.repository.DirectorRepository;

@Service
public class DirectorServiceimpl implements IDirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public DirectorDto addDirector(DirectorDto directorDto) {
        Director director = mapper.map(directorDto, Director.class);
        director = directorRepository.save(director);
        return mapper.map(director, DirectorDto.class);
    }

    @Override
    public DirectorDto getDirectorById(Long id) {
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Director not found"));
        return mapper.map(director, DirectorDto.class);
    }
}
