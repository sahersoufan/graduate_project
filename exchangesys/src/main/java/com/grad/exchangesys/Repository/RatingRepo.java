package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepo extends JpaRepository<Rating,Long> {
}
