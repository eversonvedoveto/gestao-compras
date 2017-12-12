package com.everson.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Produto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 584803558445285939L;

	//usando Long para id
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@Column(unique = true)
	private String nome;
	
	//quantidade a comprar
	private Long quantidade;
	
	//duracao de um produto apos aberto
	private Long duracaoEstimada;	
	
	//valor minimo do produto, registrado pelo usuario. Só é registrado o minimo.
	private Double valor;

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

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
