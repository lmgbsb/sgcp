package sgcp.restController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sgcp.model.Contrato;
import sgcp.model.ContratoKey;
import sgcp.service.ContratoService;

@RestController
public class ContratoRestController {
	
	private final ContratoService cs;
	
	public ContratoRestController(ContratoService cs) {
		this.cs=cs;
	}
	
	@GetMapping("/api/contrato")
	public List<Contrato> listarContratos(){
		return cs.listaContratos();
	}
	
	@PostMapping("/api/contrato")
	public Contrato incluirContrato(@RequestBody Contrato contrato){
				
		
		return cs.incluirContrato(contrato);
		
	}
	
	@DeleteMapping("/api/contrato")
	public void excluirContrato(@RequestParam("numero") Integer number,
								@RequestParam("ano") Integer year) {
		
		ContratoKey ck = new ContratoKey(number, year);
		
		cs.exluirContrato(ck);
		
	}
	
	@PutMapping("/api/contrato")
	public Contrato alterarContrato(@RequestBody Contrato contrato) {
		
		return cs.alterarContrato(contrato);
		
	}
	
	@GetMapping("/api/contrato/detalhar")
	public Contrato detalharContrato(@RequestParam("numero") Integer number,
									 @RequestParam("ano") Integer year) {
		
		ContratoKey ck = new ContratoKey(number, year);
		
		return cs.detalharContrato(ck);
		
	}

}
