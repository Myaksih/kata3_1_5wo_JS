package com.example.kata3_1_5wo_js.repository;



import com.example.kata3_1_5wo_js.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Override
    Optional<User> findById(Long id);
}