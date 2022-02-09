package com.listadetarefas.listaDeTarefas.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Tasks {

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
//==============================================================

	public Tasks() {

	}

	public Tasks(Long idTasks, String title, String description,
			@NotNull(message = "Hey! Vamos definir uma data!") LocalDate finishDate, Boolean status) {
		super();
		this.idTasks = idTasks;
		this.title = title;
		this.description = description;
		this.finishDate = finishDate;
		this.status = status;
	}

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

	public Boolean isStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	
}
