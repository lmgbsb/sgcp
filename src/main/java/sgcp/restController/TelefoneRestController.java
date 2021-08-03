package sgcp.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sgcp.dto.TelefoneDTO;
import sgcp.model.Telefone;
import sgcp.service.TelefoneService;

@RestController
@RequestMapping("/api/telefone")
public class TelefoneRestController {
	
	
	public final TelefoneService telefoneService;	
	
	
	public TelefoneRestController(TelefoneService telefoneService) {		
		this.telefoneService=telefoneService;		
	}	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Telefone incluirTelefone(@RequestBody TelefoneDTO phone) {
		return telefoneService.incluirTelefone(phone);		
	}	
	@GetMapping
	public List<Telefone> listarTelefones(){		
		return telefoneService.listarTelefones();		
	}
	@PutMapping("/{idTelefone}")
	@ResponseStatus(HttpStatus.OK)
	public Telefone alterarTelefone(@PathVariable Integer idTelefone, @RequestBody @Valid TelefoneDTO telefoneDTO) {
		if(verificaExistenciaTelefone(idTelefone)) {
			return telefoneService.alterarTelefone(telefoneDTO);
		}
		return null;
	}
	public boolean verificaExistenciaTelefone(Integer id) {
		return true;
	}
}
