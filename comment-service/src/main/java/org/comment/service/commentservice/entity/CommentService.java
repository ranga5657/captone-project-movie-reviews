package org.comment.service.commentservice.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentService {
	
	
	 @Autowired
	    CommentRepository commentRepository;
	 
	 
	 public List<Comment> listAll() {
	        return commentRepository.findAll();
	 }
	   
	 
	    public void save(Comment comment) {
	        commentRepository.save(comment);
	    }

	    
	    
	    public void delete(long id) {
	        commentRepository.deleteById(id);
	    }
	    
	    
	    
	    public Comment get(long id) {
	        return commentRepository.findById(id).get();
	    }
	    
	    

	    public List<Comment> getByLang(String moviename) {
	        return commentRepository.findBySearchFields(moviename);
	    }
	//    
}
