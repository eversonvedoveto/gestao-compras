package com.everson.repository;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;

@Repository
public class ProdutosMetodos{
	@PersistenceContext
    private EntityManager manager;	
	
	public void alterarComprado() {
		
		//Query query = manager.createQuery("select t from Tarefa as t "+"where t.finalizado = :paramFinalizado");
		manager.createQuery("Update produto set quantidade=0 where id=1"); 

		manager.close();
		
		 
	}
	
}
