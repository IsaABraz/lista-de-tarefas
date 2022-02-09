//package com.listadetarefas.listaDeTarefas.model;
//
//import javax.persistence.CascadeType;
////import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
////import javax.persistence.JoinColumn;
////import javax.persistence.OneToMany;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//
//@Entity
//public class User {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(nullable = false, unique = true)
//	private Long idUser;
//
//	@NotBlank(message = "Por favor, informe seu nome")
//	@Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula.")
//	@Size(max = 50)
//	@Column
//	private String name;
//
//	@NotNull(message = "Campo obrigatório")
//	@Pattern(regexp = ".+@.+\\.com+", message = "Informe um e-mail válido")
//	@Column(unique = true)
//	private String email;
//
//	@NotBlank(message = "É obrigatório inserir uma senha")
//	@Size(max = 20, message = "O campo não pode ultrapassar {max} caracteres")
//	@Column
//	private String password;
//
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "idTasks")
//	private Tasks tasks;
//
////=================================================
//
//	public User() {
//
//	}
//
//	public User(Long idUser,
//			@NotBlank(message = "Por favor, informe seu nome") @Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula.") @Size(max = 50) String name,
//			@NotNull(message = "Campo obrigatório") @Pattern(regexp = ".+@.+\\.com+", message = "Informe um e-mail válido") String email,
//			@NotBlank(message = "É obrigatório inserir uma senha") @Size(max = 20, message = "O campo não pode ultrapassar {max} caracteres") String password,
//			Tasks tasks) {
//		super();
//		this.idUser = idUser;
//		this.name = name;
//		this.email = email;
//		this.password = password;
//		this.tasks = tasks;
//	}
//
//	public Long getIdUser() {
//		return idUser;
//	}
//
//	public void setIdUser(Long idUser) {
//		this.idUser = idUser;
//	}
//	
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public Tasks getTasks() {
//		return tasks;
//	}
//
//	public void setTasks(Tasks tasks) {
//		this.tasks = tasks;
//	}
//
//}
