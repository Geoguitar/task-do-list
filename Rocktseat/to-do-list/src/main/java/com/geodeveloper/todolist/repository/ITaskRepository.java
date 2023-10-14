package com.geodeveloper.todolist.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geodeveloper.todolist.entities.TaskModel;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
   List<TaskModel> findByIduser(UUID iduser);
   
   //TaskModel findByIdAndIdUser(UUID id, UUID iduser);
}
