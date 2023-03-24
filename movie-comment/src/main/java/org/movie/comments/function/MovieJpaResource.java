package org.movie.comments.function;


import java.util.List;

import org.movie.comments.repository.MovieRepository;
import org.movie.comments.repository.ReviewRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RestController
public class MovieJpaResource {
	
	
	
	private MovieRepository movieRepository;
	
	private ReviewRepository reviewRepository;
	
	
	@GetMapping("/jpa/movies")
	public List<Movie> retriveAllUswers(){
		return movieRepository.findAll();
	}
	

}
