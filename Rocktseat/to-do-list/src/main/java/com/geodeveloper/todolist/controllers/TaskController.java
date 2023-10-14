package com.geodeveloper.todolist.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geodeveloper.todolist.Utils.Utils;
import com.geodeveloper.todolist.entities.TaskModel;
import com.geodeveloper.todolist.repository.ITaskRepository;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository iTaskRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
                    //getAttribute recupera o iduser passado pela requisição 
        var idUser = request.getAttribute("iduser");
        taskModel.setIduser((UUID) idUser);

            var currentDate = LocalDateTime.now();

            if (currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("A data de inicio/data término, deve ser maior que a atual.");
            }

             if (taskModel.getStartAt().isAfter(taskModel.getEndAt())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("A data de inicio deve ser menor que a de término.");
            }

        var task = this.iTaskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping("/")
    public List<TaskModel> list(HttpServletRequest request) {
        var idUser = request.getAttribute("iduser");
        var tasks = this.iTaskRepository.findByIduser((UUID) idUser);
        return tasks;
    }

    @PutMapping("/{id}")
    public void update(@RequestBody TaskModel taskModel, @PathVariable UUID id, HttpServletRequest request) {
        var idUser = request.getAttribute("iduser");

        var task = this.iTaskRepository.findById(id).orElse(null);

        Utils.copyNonNullProperties(taskModel, task);

        this.iTaskRepository.save(taskModel);
    }

}
