package org.comment.service.commentservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment_data")

public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "moviename")
	private String moviename;
	
	@Lob
	@Column(name = "comment", length=512)
	private String comment;

	@Column(name = "rating")
	private float rating;

	@Column(name = "createdat", nullable = false, updatable = false)
	private String createdat;

	@Column(name = "updatedat", nullable = false)
	private String updatedat;
	
	
}