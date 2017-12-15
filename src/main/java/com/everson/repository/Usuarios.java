package com.everson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everson.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {

	Usuario findByLogin(String login);
}