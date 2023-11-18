package com.example.geeks.repository;

import com.example.geeks.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task,Long> {

}
