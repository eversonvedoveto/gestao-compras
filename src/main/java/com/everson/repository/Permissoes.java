package com.everson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everson.model.Grupo;
import com.everson.model.Permissao;

public interface Permissoes extends JpaRepository<Permissao, Long> {
	
	List<Permissao> findByGruposIn(Grupo grupo);

}