package sgcp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import sgcp.model.DadosPessoais;
import sgcp.service.PessoaService;

@Controller
public class PessoaController {	
	
	
	private final PessoaService ps;	
	
	
	public PessoaController(PessoaService ps) {
		this.ps=ps;
	}
	/*Formulário inclusão pessoa*/
	@GetMapping("/pessoa")
	public ModelAndView fip() {		
		ModelAndView mv = new ModelAndView("incluirPessoa");
		mv.addObject("person", new DadosPessoais());
		return mv;		
	}	
	@PostMapping("/pessoa")
	public ModelAndView incluirPessoa(@ModelAttribute  DadosPessoais p) {			
		ps.IncluirPessoa(p);		
		ModelAndView mv = new ModelAndView("confirmaInclusaoPessoa");
		mv.addObject("criatura", p);		
		return mv;
	}
}
