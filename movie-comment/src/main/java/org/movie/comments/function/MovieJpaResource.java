package org.movie.comments.function;


import java.net.URI;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.movie.comments.repository.MovieRepository;
import org.movie.comments.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//<<<<<<< HEAD
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//=======
//
//
//>>>>>>> branch 'main' of https://github.com/ranga5657/captone-project-movie-reviews.git
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
	
	
	@GetMapping("/jpa/movies/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable(value = "id") int id)
			throws MovieNotFoundException {
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new MovieNotFoundException("Movie not found for this id :: " + id));
		return ResponseEntity.ok().body(movie);
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
	
	@RequestMapping(value = "/jpa/movies/{id}", method = RequestMethod.PATCH, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Movie> updateMoviebyid(@PathVariable(value = "id") int id,
			@RequestBody Movie movieDetails) throws MovieNotFoundException {
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new MovieNotFoundException("Movie not found for this id :: " + id));

		@SuppressWarnings("unused")
		Movie adminservice = new Movie();
 
		String pattern = "dd/MM/yyyy hh:mm:ss";

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		
//		String pattern = "dd/MM/yyyy hh:mm:ss";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		String date = simpleDateFormat.format(new Date());		
		
		movie.setMoviename(movieDetails.getMoviename());
		movie.setCast(movieDetails.getCast());
		movie.setDirector(movieDetails.getDirector());
		movie.setGenre(movieDetails.getGenre());
		movie.setReleasedate(movieDetails.getReleasedate());
		movie.setSummary(movieDetails.getSummary());
		movie.setLanguage(movieDetails.getLanguage());
		movie.setPicture(movieDetails.getPicture());
		movie.setVideolink(movieDetails.getVideolink());
		movie.setCreatedDate(movieDetails.getCreatedDate());
		movie.setUpdatedDate(movieDetails.getUpdatedDate());
		
		
		final Movie updatedMovie = movieRepository.save(movie);

		return (ResponseEntity<Movie>) ResponseEntity.ok(updatedMovie);
	}
	
	
	
	@PostMapping("/jpa/movies/{id}/reviews")
	public ResponseEntity<Object> createReviewForMovie(@PathVariable int id, @RequestBody Review review) {
		Optional<Movie> movie = movieRepository.findById(id);
		
		if(movie.isEmpty())
			throw new MovieNotFoundException("id:"+id);
		
		review.setMovie(movie.get());
		
		Review savedReview = reviewRepository.save(review);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedReview.getReviewId())
				.toUri();   

		return ResponseEntity.created(location).build();

	}
	

}
