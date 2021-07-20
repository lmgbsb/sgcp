package sgcp.restController;

import java.util.List;
import java.util.Locale;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgcp.model.Contrato;
import sgcp.model.ContratoKey;
import sgcp.service.ContratoService;

@RestController
@RequestMapping("/api/contrato")
public class ContratoRestController {
	
	private final ContratoService cs;
	
	public ContratoRestController(ContratoService cs) {
		this.cs=cs;
	}
	
	@GetMapping
	public ResponseEntity<List<Contrato>> listarContratos(){
		return ResponseEntity.ok(cs.listaContratos());
	}
	
	@GetMapping("/{numero}/{ano}")
	public ResponseEntity<Contrato> detalharContrato(
										@PathVariable("numero") Integer number,
										@PathVariable("ano") Integer year) {
		
		ContratoKey ck = new ContratoKey(number, year);
		
		Contrato contrato =  cs.detalharContrato(ck);
		
		return ResponseEntity.ok(contrato);
		
	}
	
	@PostMapping
	public ResponseEntity<String> incluirContrato(
									@RequestBody Contrato contrato,
									@RequestHeader(value = "Accept-Language",required = false) Locale locale){
						
		return ResponseEntity.ok(cs.incluirContrato(contrato, locale));
		
	}
	
	@PutMapping("/{numero}/{ano}")
	public ResponseEntity<String> alterarContrato(
			@RequestBody Contrato contrato,
			@RequestHeader(value = "Accept-Language",required = false) Locale locale){
		
		return ResponseEntity.ok(cs.alterarContrato(contrato, locale));
		
	}
	
	@DeleteMapping("/{numero}/{ano}")
	public ResponseEntity<String> excluirContrato(
			@PathVariable("numero") Integer number,
			@PathVariable("ano") Integer year,
			@RequestHeader(value = "Accept-Language",required = false) Locale locale){

			ContratoKey ck = new ContratoKey(number, year);
						
			return ResponseEntity.ok(cs.exluirContrato(ck, locale));	
		
	}

}
