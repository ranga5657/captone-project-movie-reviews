package org.movie.comments.function;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	private int id;
	private String comment;
	private String rating;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Movie movie;

}
