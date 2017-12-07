package com.everson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;

import com.everson.model.Produto;
import com.everson.repository.Produtos;



@Controller
public class ProdutoController {
	//inicializando Produtos repositorio
	@Autowired
	private Produtos produtos;
	
	@GetMapping("/")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaProdutos");
		mv.addObject(new Produto());
		mv.addObject("produtos", produtos.findAll());
		return mv;
	}
	
	@PostMapping("/")
	public String salvar(Produto produto) {
		//metodo acessa o repositorio Produtos(classe) e chama a funcao save passando como parametro o "produto"
		this.produtos.save(produto);
		return "redirect:/";
	}
	
	@GetMapping(value = "remover/{id}")
	public String remover(@PathVariable("id") Long id) {
		
		this.produtos.delete(id);
		
		
		
		//mv.addObject("globalMessage","Cliente removido com sucesso");
	
		return "redirect:/";
	}
}
