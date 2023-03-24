package org.movie.comments.function;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.movie.comments.repository.MovieRepository;
import org.movie.comments.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
//	@GetMapping("/jpa/movie/{id}")
//	public EntityModel<Movie> retrieveMovie(@PathVariable int id) {
//		Optional<Movie> movie = movieRepository.findById(id);
//		
//		if(movie.isEmpty())
//			throw new MovieNotFoundException("id:"+id);
//		
//		EntityModel<Movie> entityModel = EntityModel.of(movie.get());
//		
//		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllMovies());
//		entityModel.add(link.withRel("all-movies"));
//		
//		return entityModel;
//	}
	
	@DeleteMapping("/jpa/movies/{id}")
	public void deleteMovie(@PathVariable int id) {
		movieRepository.deleteById(id);
	}
	
	@GetMapping("/jpa/movies/{id}/reviews")
	public List<Review> retrieveReviewsForMovies(@PathVariable int id) {
		Optional<Movie> movie = movieRepository.findById(id);
		
		if(movie.isEmpty())
			throw new MovieNotFoundException("id:"+id);
		
		return movie.get().getReviews();

	}
	

	@PostMapping("/jpa/movies")
	public ResponseEntity<Movie> createMovie( @RequestBody Movie movie) {
		
		Movie savedMovie = movieRepository.save(movie);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedMovie.getId())
						.toUri();   
		
		return ResponseEntity.created(location).build();
	}
	

}
