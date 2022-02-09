package com.listadetarefas.listaDeTarefas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.listadetarefas.listaDeTarefas.DTO.TasksDTO;
import com.listadetarefas.listaDeTarefas.model.Tasks;
import com.listadetarefas.listaDeTarefas.repository.TasksRepository;

//CLASSE RESPONSÁVEL PELAS REGRAS DE NEGÓCIO

@Service
public class TasksService {

	@Autowired
	private TasksRepository repository;

	// -------------- LIST ALL TASKS --------------
	public List<TasksDTO> findAll() {
		List<Tasks> task = repository.findAll();
		List<TasksDTO> tasksDtos = new ArrayList<TasksDTO>();

		for (Tasks tasks : task) {
			// ESTAVA SENTINDO FALTA DO MEU CONSTRUTOR NO DTO
			TasksDTO TasksDto = new TasksDTO(tasks);
			tasksDtos.add(TasksDto);
		}
		return tasksDtos;
	}

	// -------------- FIND BY TITLE --------------
	public List<TasksDTO> getByTitle(String title) {
		List<TasksDTO> tasksDTO = new ArrayList<TasksDTO>();
		List<Tasks> tasks = repository.findAll();

		for (Tasks task : tasks) {
			if (title.isBlank() || title.isEmpty()) {
				if (task.getTitle().contentEquals(title)) {
					TasksDTO noTitle = new TasksDTO(task);
					tasksDTO.add(noTitle);
				}
			}
			
// ISSO AQUI QUE TAVA RETORNANDO DUPLICADO
//			if (title.contains(task.getTitle()) || task.getTitle().contains(title)) {
//				TasksDTO sequenceTitle = new TasksDTO(task);
//				tasksDTO.add(sequenceTitle);
//			}
			
			if (task.getTitle().equalsIgnoreCase(title)) {
				TasksDTO convertTaskToDTO = new TasksDTO(task);
				tasksDTO.add(convertTaskToDTO);
			}
		}
		return tasksDTO;
	}
	
	
	
	// -------------- FIND BY ID --------------
	// ENCONTRA PESSOAS PELO ID 
		public List<TasksDTO> getByIdTasks(long idTasks) {
			List<TasksDTO> tasksDTO = new ArrayList<>();
			List<Tasks> tasks = repository.findAll();
			for (Tasks task : tasks) {
				if (task.getIdTasks() == idTasks) {
					TasksDTO convertTasksToDTO = new TasksDTO(task);
					tasksDTO.add(convertTasksToDTO);
				}
			}
			return tasksDTO;
		}

	// -------------- POST --------------
	public TasksDTO addTask(TasksDTO tasksDTO) {
		Tasks tasks = new Tasks();
		tasks.setTitle(tasksDTO.getTitle());
		tasks.setDescription(tasksDTO.getDescription());
		tasks.setFinishDate(tasksDTO.getFinishDate());
		tasks.setStatus(tasksDTO.isStatus());
		Tasks newTasks = repository.save(tasks);

		System.out.println(tasks);
		return new TasksDTO(newTasks);
	}

	// -------------- UPDATE --------------

	public TasksDTO updateTask(Long idTasks, TasksDTO tasksDTO) {
		Optional<Tasks> tasks = repository.findById(idTasks);

		if (!repository.existsById(idTasks)) {
			return null;
		}
		tasks.get().setTitle(tasksDTO.getTitle());
		tasks.get().setDescription(tasksDTO.getDescription());
		tasks.get().setFinishDate(tasksDTO.getFinishDate());

		Tasks updateTask = repository.save(tasks.get());
		return new TasksDTO(updateTask);
	}

	// -------------- UPDATE STATUS --------------

	public TasksDTO setStatus(Long idTasks) {
		Optional<Tasks> tasks = repository.findById(idTasks);
		if (!tasks.isPresent()) {
			return null;
		}
		tasks.get().setStatus(true);

		Tasks updateTasks = repository.save(tasks.get());
		return new TasksDTO(updateTasks);
	}

	// -------------- DELETE --------------
	public void delete(Long idTasks) {
		repository.deleteById(idTasks);
		;
	}

}
