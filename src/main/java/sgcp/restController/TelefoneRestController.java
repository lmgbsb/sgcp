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
	
	
	public final TelefoneService ts;	
	
	
	public TelefoneRestController(TelefoneService ts) {		
		this.ts=ts;		
	}	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Telefone incluirTelefone(Telefone phone) {
		return ts.incluirTelefone(phone);		
	}	
	@GetMapping
	public List<Telefone> listarTelefones(){		
		return ts.listarTelefones();		
	}
	@PutMapping("/{idTelefone}")
	@ResponseStatus(HttpStatus.OK)
	public Telefone alterarTelefone(@PathVariable Integer idTelefone, @RequestBody @Valid TelefoneDTO telefoneDTO) {
		if(verificaExistenciaTelefone(idTelefone)) {
			return ts.alterarTelefone(telefoneDTO);
		}
		return null;
	}
	public boolean verificaExistenciaTelefone(Integer id) {
		return true;
	}
}
