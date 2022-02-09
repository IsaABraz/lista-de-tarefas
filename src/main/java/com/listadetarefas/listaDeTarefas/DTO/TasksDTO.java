package com.listadetarefas.listaDeTarefas.DTO;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.listadetarefas.listaDeTarefas.model.Tasks;

public class TasksDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long idTasks;

	@Column
	private String title;

	@Column
	private String description;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Hey! Vamos definir uma data!")
	@Column
	private LocalDate finishDate;

	@Column
	private Boolean status;

	public TasksDTO() {
	
	}

//	public TasksDTO(Long idTasks, String title, String description,
//			@NotNull(message = "Hey! Vamos definir uma data!") LocalDate finishDate, Boolean status) {
//		super();
//		this.idTasks = idTasks;
//		this.title = title;
//		this.description = description;
//		this.finishDate = finishDate;
//		this.status = status;
//	}
//	
	//NA PRIMEIRA PARTE ME REFIRO AO MEU DTO E A SEGUNDA AO MEU DOMÍNIO. EU ESTPU FAZENDO A RELAÇÃO ENTRE ELES.
	public TasksDTO(Tasks tasks) {
		this.idTasks = tasks.getIdTasks();
		this.title = tasks.getTitle();
		this.description = tasks.getDescription();
		this.finishDate = tasks.getFinishDate();
		this.status = tasks.isStatus();
	}

	// CRIAMOS NOSSOS GETs E SETs. GET - obter informação | SET - definir valores. AQUI DECIDIMOS O QUE VAMOS RETORNAR PARA O 
	// USUÁRIO QUANDO ELE FIZER UM GET DE UM "BLOCO" DE INFORMAÇÃO, POR EXEMPLO. 
	
	public Long getIdTasks() {
		return idTasks;
	}

	public void setIdTasks(Long idTasks) {
		this.idTasks = idTasks;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	
	
}
