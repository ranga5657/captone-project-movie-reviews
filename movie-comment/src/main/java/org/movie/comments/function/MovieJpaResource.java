package org.movie.comments.function;


import java.util.List;

import org.movie.comments.repository.MovieRepository;
import org.movie.comments.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MovieJpaResource {
	
	
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	
	
	
	@GetMapping("/jpa/movies")
	public List<Movie> retriveAllUswers(){
		return movieRepository.findAll();
	}
	

}
