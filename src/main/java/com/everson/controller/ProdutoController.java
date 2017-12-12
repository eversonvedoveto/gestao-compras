package com.everson.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
		//this.produtos.save(produto);
		this.produtos.saveAndFlush(produto);
		return "redirect:/";
	}
	
	@GetMapping(value = "remover/{id}")
	public String remover(@PathVariable("id") Long id) {
		
		this.produtos.delete(id);
		
		
		//mv.addObject("globalMessage","Cliente removido com sucesso");
	
		return "redirect:/";
	}
	
	@GetMapping(value = "alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Produto produto, RedirectAttributes redirect) {		
		return new ModelAndView("alterar-produto","produto",produto);
		//return new ModelAndView();
	}
	
//	@PostMapping(params = "form")
//	public ModelAndView create(@Valid Produto produto,BindingResult result,RedirectAttributes redirect) {
//		if (result.hasErrors()) { return new ModelAndView("form","formErrors",result.getAllErrors()); }
//		produto = this.produtos.save(produto);
//		redirect.addFlashAttribute("globalMessage","Produto gravado com sucesso");
//		return new ModelAndView("redirect:/");
//	}
}
