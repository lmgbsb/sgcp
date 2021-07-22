package sgcp.restController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgcp.model.DadosPessoais;
import sgcp.service.DadosPessoaisService;

@RestController
@RequestMapping("/api/dadospessoais")
public class DadosPessoaisRestController {

	private final DadosPessoaisService dps;
	
	public DadosPessoaisRestController(DadosPessoaisService dps) {
		this.dps = dps;
	}
	
	@GetMapping
	public ResponseEntity<List<DadosPessoais>> listarDadosPessoais(){
		
		return ResponseEntity.ok(dps.listarDadosPessoais());
		
	}
	
	@PostMapping
	public ResponseEntity<DadosPessoais> incluirDadosPessoais(@RequestBody DadosPessoais dp){
		
		return ResponseEntity.ok(dps.incluirDadosPessoais(dp));
		
	}
	
	@DeleteMapping("/{cpf}")
	public ResponseEntity excluirDadosPessoais(@PathVariable String cpf) {
		
		dps.excluirDadosPessoais(cpf);
		
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<DadosPessoais> alterarDadosPessoais(@RequestBody DadosPessoais dp){
		
		return ResponseEntity.ok(dps.alterarDadosPessoais(dp));
		
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity<DadosPessoais> detalharDadosPessoais(@PathVariable String cpf){
	
		Optional<DadosPessoais> dp = dps.detalharDadosPessoais(cpf);
		
		//caminho feliz
		DadosPessoais dados = new DadosPessoais();
		if(dp.isPresent()) {
			dados = dp.get().add( 
					linkTo(methodOn(DadosPessoaisRestController.class).excluirDadosPessoais(cpf)).withRel("excluirDadosPessoais")
			);			
		}
		
		return ResponseEntity.ok(dados);
		
		
		
	}
}
