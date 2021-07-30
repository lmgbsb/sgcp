package sgcp.restController;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sgcp.dto.ContratoDTO;
import sgcp.model.Contrato;
import sgcp.model.ContratoKey;
import sgcp.service.ContratoService;

@RestController
@RequestMapping("/api/contrato")
public class ContratoRestController {	
	private final ContratoService contratoService;	
	public ContratoRestController(ContratoService contratoService) {
		this.contratoService=contratoService;
	}	
	@GetMapping
	public List<Contrato> listarContratos(){
		return contratoService.listaContratos();
	}	
	@GetMapping("/{numero}/{ano}")
	public ResponseEntity<Contrato> detalharContrato(
										@PathVariable("numero") Integer number,
										@PathVariable("ano") Integer year) {
		
		ContratoKey ck = new ContratoKey(number, year);		
		Contrato contrato =  contratoService.detalharContrato(ck);		
		return ResponseEntity.ok(contrato);		
	}
	
	/*
	@PostMapping
	public ResponseEntity<String> incluirContrato(
									@RequestBody Contrato contrato,
									@RequestHeader(value = "Accept-Language",required = false) Locale locale){
						
		return ResponseEntity.ok(contratoService.incluirContrato(contrato, locale));
		
	}
	*/
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Contrato incluirContrato(@RequestBody @Valid ContratoDTO contratoDTO) {
		return contratoService.incluirContrato(contratoDTO);
	}	
	@PutMapping("/{numero}/{ano}")
	public ResponseEntity<String> alterarContrato(
			@RequestBody Contrato contrato,
			@RequestHeader(value = "Accept-Language",required = false) Locale locale){
		
		return ResponseEntity.ok(contratoService.alterarContrato(contrato, locale));		
	}
	
	@DeleteMapping("/{numero}/{ano}")
	public ResponseEntity<String> excluirContrato(
			@PathVariable("numero") Integer number,
			@PathVariable("ano") Integer year,
			@RequestHeader(value = "Accept-Language",required = false) Locale locale){

			ContratoKey ck = new ContratoKey(number, year);						
			return ResponseEntity.ok(contratoService.exluirContrato(ck, locale));			
	}
}
