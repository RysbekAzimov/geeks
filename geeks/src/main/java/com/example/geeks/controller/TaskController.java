package com.example.geeks.controller;

import com.example.geeks.dto.TaskDto;
import com.example.geeks.entity.Task;
import com.example.geeks.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

        private final TaskServiceImpl taskService;

        public TaskController(TaskServiceImpl taskService) {
            this.taskService = taskService;
        }

        @GetMapping
        public List<Task> getAllTasks() {
            return taskService.getAllTasks();
        }

        @PostMapping("/add")
        public Task createTask(@RequestBody TaskDto taskDto) {
            return taskService.createTask(taskDto);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
            Task task = taskService.getTaskById(id);
            return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskDto updatedTaskDto) {
            Task updatedTask = taskService.updateTask(id, updatedTaskDto);
            return updatedTask != null ? ResponseEntity.ok(updatedTask) : ResponseEntity.notFound().build();
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteTask(@PathVariable Long id) {
            return taskService.deleteTask(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
        }
    }