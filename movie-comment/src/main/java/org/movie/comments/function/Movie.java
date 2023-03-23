package org.movie.comments.function;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	
	
	//fefefwfw4ef

}
