package sgcp.restController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<Telefone> incluirTelefone(Telefone phone) {

		return ResponseEntity.ok(ts.incluirTelefone(phone));
		
	}
	
	@GetMapping
	public List<Telefone> listarTelefones(){
		
		return ts.listarTelefones();
		
	}

	

}
