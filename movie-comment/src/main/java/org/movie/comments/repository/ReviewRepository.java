package org.movie.comments.repository;

import org.movie.comments.function.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Integer>{

}
