package com.everson.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@GetMapping("/login")
	public String login() {
		return "login";
}
	
	@GetMapping("/")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaProdutos");
		mv.addObject(new Produto());
		mv.addObject("produtos", produtos.findAll());
		return mv;
	}
	
	@PostMapping("/")
	public ModelAndView salvar(Produto produto, RedirectAttributes attributes) throws Exception{
		//metodo acessa o repositorio Produtos(classe) e chama a funcao save passando como parametro o "produto"
		//implementado exception para caso salvou e para caso nao salvou
		try {
			this.produtos.saveAndFlush(produto);
			ModelAndView mv = new ModelAndView("redirect:/");
			attributes.addFlashAttribute("mensagem", "Salvo com sucesso.");
			return mv;
		}catch (Exception ex) {
			ModelAndView mv = new ModelAndView("redirect:/");
			attributes.addFlashAttribute("mensagemErro", "Erro ao salvar produto, verifique não esta duplicando");
			return mv;
		}
		
	}
	
		
	@GetMapping(value = "remover/{id}")
	public String remover(@PathVariable("id") Long id, RedirectAttributes attributes) throws Exception{
		try {
			this.produtos.delete(id);		
			attributes.addFlashAttribute("mensagemApagado", "Apagado com sucesso");
			return "redirect:/";
		}catch (Exception ex) {
			attributes.addFlashAttribute("mensagemApagado", "Erro ao apagar");
			return "redirect:/";
		}
	
	
	}
	
	@GetMapping(value = "alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Produto produto, RedirectAttributes attributes) {
		
		return new ModelAndView("alterar-produto","produto",produto);		
	}
	
	@GetMapping(value = "comprado/{id}")
	public ModelAndView comprado(@PathVariable("id") Produto produto, RedirectAttributes attributes) {		
		return new ModelAndView("comprado","produto",produto);		
	}
	

}
