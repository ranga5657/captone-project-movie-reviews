package org.movie.comments.function;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {
	
	
	@Id
	@GeneratedValue
	private int id;
	private String moviename;
	private String cast;
	private String genre;
	private String director;
	
	@OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Review> reviews;
	
	
	//fefefwfw4ef

}
