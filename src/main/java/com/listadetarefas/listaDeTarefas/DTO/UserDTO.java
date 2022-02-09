//package com.listadetarefas.listaDeTarefas.DTO;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//
//import com.listadetarefas.listaDeTarefas.model.Tasks;
//import com.listadetarefas.listaDeTarefas.model.User;
//
//public class UserDTO {
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
////	=======================================================================
//	
//	public UserDTO() {
//		super();
//	}
//
//public UserDTO(Long idUser,
//		@NotBlank(message = "Por favor, informe seu nome") @Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula.") @Size(max = 50) String name,
//		@NotNull(message = "Campo obrigatório") @Pattern(regexp = ".+@.+\\.com+", message = "Informe um e-mail válido") String email,
//		@NotBlank(message = "É obrigatório inserir uma senha") @Size(max = 20, message = "O campo não pode ultrapassar {max} caracteres") String password,
//		Tasks tasks) {
//	super();
//	this.idUser = idUser;
//	this.name = name;
//	this.email = email;
//	this.password = password;
//	this.tasks = tasks;
//}
//
//public UserDTO(User user) {
//	super();
//	this.idUser = user.getIdUser();
//	this.name = user.getName();
//	this.email = user.getEmail();
//	this.password = user.getPassword();
//	this.tasks = tasks;
//}
//	
//	
//	
//
//}
