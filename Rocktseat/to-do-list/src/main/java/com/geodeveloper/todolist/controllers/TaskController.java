package com.geodeveloper.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geodeveloper.todolist.entities.TaskModel;
import com.geodeveloper.todolist.repository.ITaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository iTaskRepository;

    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel) {
        var task = this.iTaskRepository.save(taskModel);
        return task;
    }
}
