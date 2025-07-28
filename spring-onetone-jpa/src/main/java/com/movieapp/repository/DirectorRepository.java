package com.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieapp.model.Director;

public interface DirectorRepository extends JpaRepository<Director, Long> {

}
