package com.everson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everson.model.Produto;

public interface Produtos extends JpaRepository<Produto, Long>{
//este é um repositorio, aqui onde faz as interacoes com o banco, insertinto, alter, delete
}
