package com.everson.starter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.everson.model.Produto;
import com.everson.repository.Produtos;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsereProdutoTests {
	@Autowired
	private Produtos produtos;
	
	
	Produto produto = new Produto();
	
	//inserindo um sabao no banco
	@Before
	public void insereUmSabaoNoBanco() {
		
		
		produto.setNome("Pera");
		produto.setQuantidade((long) 1);
		produto.setValor((double) 10);
		produto.setDuracaoEstimada((long) 1);
		
		this.produtos.saveAndFlush(produto);
		
	}
	
	@Test
	public void TestaSeInseriuUmSabaoNoBanco() {
		boolean object = false;
		System.out.println("Objeto iniciou: "+object);
		//busca o id no banco pra ver se o produto existe
		object = this.produtos.exists(produto.getId());
		System.out.println("Objeto ficou: "+object);
		
		
		Assert.assertTrue(object);
	}
	
	@After
	public void voltaAoEstadoOriginalDoBanco() {
		this.produtos.delete(produto);
	}
	
	//FIM----inserindo um sabao no banco
	
	

}
