package org.movie.comments.repository;

import org.movie.comments.function.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer>{

}
