package com.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieapp.model.Actor;
import com.movieapp.model.Director;

public interface ActorRepository extends JpaRepository<Actor, Long> 
 {

}
