package com.nubbnueng.todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nubbnueng.todoList.model.Task;

@Repository
public interface TodoListRepository extends JpaRepository<Task, Long> {

}
