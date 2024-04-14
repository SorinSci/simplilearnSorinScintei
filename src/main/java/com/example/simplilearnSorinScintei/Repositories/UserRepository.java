package com.example.simplilearnSorinScintei.Repositories;

import com.example.simplilearnSorinScintei.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.fullName = :username")
    User getByUsername(String username);
}
