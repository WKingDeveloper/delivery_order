package com.example.order.repository.user;

import com.example.order.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserId(String userId);
    Optional<User> findByBusinessNumber(String businessNumber);

}
