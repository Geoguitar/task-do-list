package com.geodeveloper.todolist.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(length = 50)
    private String title;

    @Column(length = 50)
    private String priority;

    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    private UUID iduser;
    
    @CreationTimestamp
    private LocalDateTime createAt;

    public void setTitle(String title) throws Exception {

        if (title.length() > 50) {
            throw new Exception("O campo título permite 50 caracteres no máximo!");
        }
        this.title = title;
    }

     public void setPriority(String priority) throws Exception {
        
        if (priority.length() > 50) {
            throw new Exception("O campo prioridade permite 50 caracteres no máximo!");
        }
        this.priority = priority;
    }

}
