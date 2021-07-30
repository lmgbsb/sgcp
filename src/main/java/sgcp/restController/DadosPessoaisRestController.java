package sgcp.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sgcp.dto.DadosPessoaisDTO;
import sgcp.exception.DadosPessoaisNaoEncontradosException;
import sgcp.model.DadosPessoais;
import sgcp.service.DadosPessoaisService;

@RestController
@RequestMapping("/api/dadospessoais")
public class DadosPessoaisRestController {
	private final DadosPessoaisService dadosPessoaisService;	
	public DadosPessoaisRestController(DadosPessoaisService dadosPessoaisService) {
		this.dadosPessoaisService = dadosPessoaisService;
	}
	@GetMapping
	public ResponseEntity<List<DadosPessoais>> listarDadosPessoais(){		
		return ResponseEntity.ok(dadosPessoaisService.listarDadosPessoais());		
	}	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<DadosPessoais> incluirDadosPessoais(@RequestBody @Valid DadosPessoaisDTO dto){		
		return ResponseEntity.ok(dadosPessoaisService.incluirDadosPessoais(dto));		
	}	
	@DeleteMapping("/{cpf}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirDadosPessoais(@PathVariable String cpf) throws DadosPessoaisNaoEncontradosException {
		dadosPessoaisService.excluirDadosPessoais(cpf);
	}	
	@PutMapping("/{cpf}")
	public DadosPessoais alterarDadosPessoais(
			@PathVariable String cpf, 
			@RequestBody @Valid DadosPessoaisDTO dto)  throws DadosPessoaisNaoEncontradosException {
		
		return dadosPessoaisService.alterarDadosPessoais(cpf, dto);
	}
	
	/*
	 * @GetMapping("/{cpf}") public ResponseEntity<DadosPessoais>
	 * detalharDadosPessoais(@PathVariable String cpf){
	 * 
	 * Optional<DadosPessoais> dp = dadosPessoaisService.detalharDadosPessoais(cpf);
	 * 
	 * //caminho feliz DadosPessoais dados = new DadosPessoais(); if(dp.isPresent())
	 * { dados = dp.get().add(
	 * linkTo(methodOn(DadosPessoaisRestController.class).excluirDadosPessoais(cpf))
	 * .withRel("excluirDadosPessoais") ); }
	 * 
	 * return ResponseEntity.ok(dados); }
	 */
	
	@GetMapping("/{cpf}") 
	public DadosPessoais detalharDadosPessoais(@PathVariable String cpf) throws DadosPessoaisNaoEncontradosException {
		return dadosPessoaisService.detalharDadosPessoais(cpf);
	}
}
