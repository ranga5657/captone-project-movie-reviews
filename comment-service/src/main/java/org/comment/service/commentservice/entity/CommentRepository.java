
package org.comment.service.commentservice.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{
	
	List<Comment> findAll();
	
	@Query(value="SELECT * FROM comments_data cd WHERE cd.rating LIKE '4%' ",nativeQuery=true)
	List<Comment>  getBestMovies();
	
	
	@Query(value="SELECT * FROM comments_data cd WHERE cd.rating LIKE '5%' ",nativeQuery=true)
	List<Comment>  getTrending();
	

	
	@Query(value="SELECT * FROM comments_data cd WHERE cd.moviename=?#{[0]}",nativeQuery=true)
	
	//d p 

		List<Comment> findBySearchFields(String moviename);

	

}



