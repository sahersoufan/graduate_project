package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface OffersRepo extends JpaRepository<Offers, Long> {


}
