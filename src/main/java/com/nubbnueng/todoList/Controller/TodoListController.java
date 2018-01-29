package com.nubbnueng.todoList.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nubbnueng.todoList.model.Task;
import com.nubbnueng.todoList.model.TaskStatus;
import com.nubbnueng.todoList.repository.TodoListRepository;

@RestController
@RequestMapping("/api")
public class TodoListController {

	@Autowired
	TodoListRepository todoListRepository;

	// view all tasks
	@GetMapping("/tasks")
	public List<Task> getAllTasks() {
		return todoListRepository.findAll();
	}

	// view a single task
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") Long id) {
		Task task = todoListRepository.findOne(id);
		return (task == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(task);
	}

	// add task
	@PostMapping("/task")
	public Task createTask(@Valid @RequestBody Task task) {
		return todoListRepository.save(task);
	}

	// edit existing task
	@PutMapping("/task/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable(value = "id") Long id, @Valid @RequestBody Task taskDetail) {
		Task task = todoListRepository.findOne(id);

		if (task == null) {
			return ResponseEntity.notFound().build();
		}

		task.setSubject(taskDetail.getSubject());
		task.setContent(taskDetail.getContent());
		// task.setDone(taskDetail.isDone());
		task.setStatus(taskDetail.getStatus());

		Task updatedTask = todoListRepository.save(task);
		return ResponseEntity.ok(updatedTask);
	}
	
	// edit status of existing task
	@PutMapping("/task/{id}/status/{status}")
	public ResponseEntity<Task> updateTaskStatus(@PathVariable(value = "id") Long id, @PathVariable(value = "status") String status) {
		Task task = todoListRepository.findOne(id);
		
		if (task == null) {
			return ResponseEntity.notFound().build();
		}
		
		task.setStatus(TaskStatus.valueOf(status.toUpperCase()));
		
		Task updatedTask = todoListRepository.save(task);
		return ResponseEntity.ok(updatedTask);
	}

	// delete a task
	@DeleteMapping("/task/{id}")
	public ResponseEntity<Task> deleteTask(@PathVariable(value = "id") Long id) {
		Task task = todoListRepository.findOne(id);
		if (task == null) {
			return ResponseEntity.notFound().build();
		}

		todoListRepository.delete(task);
		return ResponseEntity.ok().build();
	}

}
