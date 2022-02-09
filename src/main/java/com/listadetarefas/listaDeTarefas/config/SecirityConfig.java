package com.listadetarefas.listaDeTarefas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecirityConfig extends WebSecurityConfigurerAdapter{
	
// QUANDO EU COLOCO A SPRING SECURITY, ELE "FECHA" A MINHA API. QUANDO VOU FAZER A SEEGURANÇA DA MINHA API, EU TENHO QUE
// IMPLEMENTAR A MINHA SecirityConfig, PARA ENTÃO TER ACESSO A TUDO.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		//AQUI EU LIBERO TUDO APÓS A BARRA (/)
		http.authorizeRequests().antMatchers("/").permitAll();
	}

}
