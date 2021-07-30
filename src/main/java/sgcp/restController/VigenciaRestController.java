package sgcp.restController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sgcp.model.Vigencia;
import sgcp.service.VigenciaService;

@RequestMapping("/api/vigencia")
@RestController
public class VigenciaRestController {
	
	
	private VigenciaService vs;	
	
	
	public VigenciaRestController(VigenciaService vs) {
		this.vs = vs;
	}	
	@GetMapping
	public List<Vigencia> listarVigencias(){	
		return vs.listarVigencias();
	}
	@PostMapping
	public Vigencia incluirVigencia(@RequestBody Vigencia vigencia) {	
		return vs.incluirVigencia(vigencia);		
	}
	@PutMapping
	public Vigencia alterarVigencia(@RequestBody Vigencia vigencia) {	
		return vs.alterarVigencia(vigencia);
	}
	@DeleteMapping
	public void excluirVigencia(@RequestParam Integer idVigencia) {
		vs.excluirVigencia(idVigencia);
	}
}
