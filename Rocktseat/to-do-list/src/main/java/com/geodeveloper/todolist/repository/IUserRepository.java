package com.geodeveloper.todolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geodeveloper.todolist.entities.UserModel;


public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    
}
