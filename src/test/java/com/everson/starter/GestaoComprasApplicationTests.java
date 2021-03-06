package com.everson.starter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.jpa.HibernateEntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.everson.model.Produto;
import com.everson.repository.Produtos;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GestaoComprasApplicationTests {
	@Autowired
	private Produtos produtos;
	
	Produto produto = new Produto();
	
	//inserindo um sabao no banco
	@Before
	public void insereUmSabaoNoBanco() {
		
		
		produto.setNome("Sabao");
		produto.setQuantidade((long) 1);
		produto.setValor((double) 10);
		produto.setDuracaoEstimada((long) 1);
		
		this.produtos.saveAndFlush(produto);
		
	}
	
	@Test
	public void TestaSeInseriuUmSabaoNoBanco() {
		
	}
	
	@After
	public void voltaAoEstadoOriginalDoBanco() {
		this.produtos.delete(produto);
	}
	
	//FIM----inserindo um sabao no banco
	
	//Testa o Contexto
	@Test
	public void contextLoads() {		
	}
	
	

	

}
