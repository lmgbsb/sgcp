package sgcp.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sgcp.dto.VigenciaDTO;
import sgcp.model.Vigencia;
import sgcp.service.VigenciaService;

@RequestMapping("/api/vigencia")
@RestController
public class VigenciaRestController {
	
	
	private VigenciaService vigenciaService;	
	
	
	public VigenciaRestController(VigenciaService vigenciaService) {
		this.vigenciaService = vigenciaService;
	}	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vigencia incluirVigencia(@RequestBody @Valid VigenciaDTO vigenciaDTO) {	
		return vigenciaService.incluirVigencia(vigenciaDTO);		
	}
	@GetMapping
	public List<Vigencia> listarVigencias(){	
		return vigenciaService.listarVigencias();
	}	
	@PutMapping
	public Vigencia alterarVigencia(@RequestBody Vigencia vigencia) {	
		return vigenciaService.alterarVigencia(vigencia);
	}
	@DeleteMapping
	public void excluirVigencia(@RequestParam Integer idVigencia) {
		vigenciaService.excluirVigencia(idVigencia);
	}
}
