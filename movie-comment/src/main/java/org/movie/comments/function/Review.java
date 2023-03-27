package org.movie.comments.function;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {
	
	@Id
	@GeneratedValue
	
	private int reviewId;
	private String comment;
	private String rating;
	
	@ManyToOne
	private Movie movie;

}
