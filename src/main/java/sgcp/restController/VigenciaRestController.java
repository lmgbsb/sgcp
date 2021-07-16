package sgcp.restController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sgcp.model.Vigencia;
import sgcp.service.VigenciaService;

@RestController
public class VigenciaRestController {

	private VigenciaService vs;
	
	public VigenciaRestController(VigenciaService vs) {
		this.vs = vs;
	}
	
	@GetMapping("/api/vigencia")
	public List<Vigencia> listarVigencias(){
		
		return vs.listarVigencias();
		
	}
	
}
