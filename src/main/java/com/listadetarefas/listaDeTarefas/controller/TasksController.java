package com.listadetarefas.listaDeTarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.listadetarefas.listaDeTarefas.DTO.TasksDTO;
import com.listadetarefas.listaDeTarefas.exception.DateException;
import com.listadetarefas.listaDeTarefas.service.TasksService;

// NOSSOS CONTROLLERS SÃO AS CLASSES QUE POSSUEM AS REQUISIÇÕES E INTERFÁCES COM NOSSO CLIENTE. RENDERIZA AS 
// VIZUALIZAÇÕES REQUERIDAS PELO NOSSO USUÁRIO.
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/v1/api/tasks")

public class TasksController {

	@Autowired
	private TasksService service;

	// ----- LIST ALL TASKS -----
	@GetMapping("/tasks")
	public ResponseEntity<List<TasksDTO>> findAll() {
		List<TasksDTO> tasksDto = service.findAll();
		return ResponseEntity.ok(tasksDto);
	}

	// ----- LIST TASKS BY TITLE -----
	@GetMapping("/title")
	public ResponseEntity<List<TasksDTO>> findByTitle(@Valid @RequestParam(value = "title") String title) {
		return ResponseEntity.ok().body(service.getByTitle(title));
	}

	// ----- LIS TASKS BY ID -----
	@GetMapping("/{idTasks}")
	public ResponseEntity<List<TasksDTO>> findByIdTasks(@PathVariable Long idTasks) {
		List<TasksDTO> tasksDTO = service.getByIdTasks(idTasks);
		if (tasksDTO.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(tasksDTO);
	}

	// ----- POST -----
	@PostMapping
	public ResponseEntity<TasksDTO> addTasks(@Valid @RequestBody TasksDTO tasksDTO) throws DateException {
		tasksDTO = service.addTask(tasksDTO);
		return ResponseEntity.ok().body(tasksDTO);
	}
	
	// ----- PUT -----
	@PutMapping("/{idTasks}")
	public ResponseEntity<TasksDTO> updateTasks(@PathVariable(value = "idTasks") Long idTasks, @RequestBody TasksDTO tasksDTO){
		tasksDTO = service.updateTask(idTasks, tasksDTO);
		if (null != tasksDTO) {
			return ResponseEntity.ok(tasksDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// ----- DELETE -----
	@DeleteMapping("/{idTasks}")
	public ResponseEntity<Void> deleteTasks(@PathVariable Long idTasks){
		service.delete(idTasks);
		return ResponseEntity.notFound().build();
	}

}
