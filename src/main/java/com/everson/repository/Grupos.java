package com.everson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everson.model.Grupo;
import com.everson.model.Usuario;

public interface Grupos extends JpaRepository<Grupo, Long> {
	
	List<Grupo> findByUsuariosIn(Usuario usuario);

}