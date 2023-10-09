package com.devsuperior.aulaUser.repositories;

import com.devsuperior.aulaUser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
