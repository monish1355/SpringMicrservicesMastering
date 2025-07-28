package com.movieapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movieapp.model.Movie;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long>{
	
	//derived query
		//read by, query by, findby.getBy<property>
//		List<Movie> findByGenre(String genre);
//		List<Movie> findByDetailsBudget(String budget);
		
		@Query("from Movie m inner join m.details d where d.synopsis= :dsynopsis and d.durationInMinutes= :ddurationInMinutes")
		List<Movie> findBysynopsistime(@Param("dsynopsis") String synopsis,@Param("ddurationInMinutes") int durationInMinutes);

		
		
}
