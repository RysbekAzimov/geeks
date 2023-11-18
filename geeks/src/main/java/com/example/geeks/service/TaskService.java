package com.example.geeks.service;

import com.example.geeks.dto.TaskDto;
import com.example.geeks.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    Task createTask(TaskDto taskDto);

    Task getTaskById(Long id);

    Task updateTask(Long id, TaskDto updatedTaskDto);

    boolean deleteTask(Long id);
}
