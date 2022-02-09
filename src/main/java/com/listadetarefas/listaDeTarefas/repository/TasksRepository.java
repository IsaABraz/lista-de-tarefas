package com.listadetarefas.listaDeTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.listadetarefas.listaDeTarefas.model.Tasks;

// OS REPOSITÓRIOS SÃO RESPONSÁVEIS PELA COMUNICAÇÃO COM O BANCO DE DADOS DURANTE O ARMAZENAMENTO E PARA RECUPERAÇÃO DE 
// DADOS JÁ EXISTENTES.

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long>{

	public Tasks findByTitle(String title);
	
	
}
