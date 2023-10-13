package com.geodeveloper.todolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geodeveloper.todolist.entities.TaskModel;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
    
}
