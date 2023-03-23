package org.comment.service.commentservice.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4203")

@RestController
//@RequestMapping("/super6")
public class CommentController {
	
	

	@Autowired
	CommentRepository commentRepository;

	
	
	
	// api to GET list of comments

//	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("/all-comments")
	public List<Comment> getAllComments() {
		String pattern = "dd/MM/yyyy hh:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		@SuppressWarnings("unused")
		String date = simpleDateFormat.format(new Date());

		return commentRepository.findAll();
	}

	// api to CREATE or POST a comment

//	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@PostMapping("/create/comment")
	public Comment createComment(

			@Valid @RequestBody Comment com) {

		Comment comment1 = new Comment();
		String pattern = "dd/MM/yyyy hh:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());

		comment1.setComment(com.getComment());
		comment1.setRating(com.getRating());
		comment1.setMoviename(com.getMoviename());
		comment1.setCreatedat(date);
		comment1.setUpdatedat(date);
		return commentRepository.save(comment1);

	}

	// api to comment by id

//	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("/comments/{id}")
	public Comment getCommentById(@PathVariable(value = "id") Long commentId) {
		return commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException());
	}

	// api to UPDATE the comments

//	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@PatchMapping("/update/comment/{id}")
	public Comment updateComment(@PathVariable(value = "id") Long commentId, @RequestBody Comment commentDetails) {

		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException());
		String pattern = "dd/MM/yyyy hh:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		comment.setMoviename(commentDetails.getMoviename());
		comment.setComment(commentDetails.getComment());
		comment.setRating(commentDetails.getRating());
		comment.setCreatedat(date);
		comment.setUpdatedat(date);

		Comment updatedComment = commentRepository.save(comment);
		return updatedComment;
	}

	// DELETE operation

//	@PreAuthorize("hasRole('Admin')")
	@DeleteMapping("/delete/comments/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable(value = "id") Long commentId) {
		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException());

		commentRepository.delete(comment);

		return ResponseEntity.ok().build();
	}
}
