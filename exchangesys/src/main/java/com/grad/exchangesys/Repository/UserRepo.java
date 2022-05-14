package com.grad.exchangesys.Repository;


import com.grad.exchangesys.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String email);

    public static final String FIND_PROJECTS = "SELECT projectId, projectName FROM projects";

    @Query(value = FIND_PROJECTS, nativeQuery = true)
//    @Query("SELECT u.id,u.firstname,u.lastname,u.description,u.description  FROM User u,FriendRequest f " +
//            "WHERE u.Role = 1 AND " +
//            "u.id <>:id" +
//            " and  f.user_id <> :id")
    List<User> friendrequest(Long id);

    @Query("SELECT u  FROM User u WHERE u.Role = 1 AND u.username not like :username" )

    List<User> getAllusernotFrind(String username);


}
