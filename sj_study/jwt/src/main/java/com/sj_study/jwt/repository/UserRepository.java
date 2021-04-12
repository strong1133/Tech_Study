package com.sj_study.jwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.sj_study.jwt.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
