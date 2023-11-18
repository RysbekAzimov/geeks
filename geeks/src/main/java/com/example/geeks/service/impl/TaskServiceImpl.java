package com.example.geeks.service.impl;

import com.example.geeks.dto.TaskDto;
import com.example.geeks.entity.Task;
import com.example.geeks.repository.TaskRepository;
import com.example.geeks.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

 private final TaskRepository taskRepository;

 public TaskServiceImpl(TaskRepository taskRepository) {
  this.taskRepository = taskRepository;
 }

 @Override
 public List<Task> getAllTasks() {
  return taskRepository.findAll();
 }

 @Override
 public Task createTask(TaskDto taskDto) {
  Task task = new Task();
  task.setTitle(taskDto.getTitle());
  task.setDescription(taskDto.getDescription());
  return taskRepository.save(task);
 }

 @Override
 public Task getTaskById(Long id) {
  Optional<Task> optionalTask = taskRepository.findById(id);
  return optionalTask.orElse(null);
 }

 @Override
 public Task updateTask(Long id, TaskDto updatedTaskDto) {
  Optional<Task> optionalTask = taskRepository.findById(id);
  if (optionalTask.isPresent()) {
   Task task = optionalTask.get();
   task.setTitle(updatedTaskDto.getTitle());
   task.setDescription(updatedTaskDto.getDescription());
   return taskRepository.save(task);
  }
  return null;
 }

 @Override
 public boolean deleteTask(Long id) {
  Optional<Task> optionalTask = taskRepository.findById(id);
  if (optionalTask.isPresent()) {
   taskRepository.deleteById(id);
   return true;
  }
    return false;
 }
}