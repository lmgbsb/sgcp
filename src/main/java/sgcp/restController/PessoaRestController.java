package sgcp.restController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sgcp.model.Pessoa;
import sgcp.service.PessoaService;

@RestController
public class PessoaRestController {

	private final PessoaService ps;
	
	public PessoaRestController(PessoaService ps) {
		this.ps = ps;
	}
	
	@GetMapping("/api/pessoas")
	public List<Pessoa> listar(){
		
		return ps.listarPessoas();
		
	}
	
}
