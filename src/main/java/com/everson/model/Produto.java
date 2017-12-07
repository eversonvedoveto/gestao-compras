package com.everson.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 584803558445285939L;

	//usando Long para id
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private Long quantidade;
	
	private Long duracaoEstimada;	

	public Long getDuracaoEstimada() {
		return duracaoEstimada;
	}

	public void setDuracaoEstimada(Long duracaoEstimada) {
		this.duracaoEstimada = duracaoEstimada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
