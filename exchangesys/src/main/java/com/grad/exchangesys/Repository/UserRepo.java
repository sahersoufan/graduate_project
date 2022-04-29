package com.grad.exchangesys.Repository;


import com.grad.exchangesys.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String email);
}
