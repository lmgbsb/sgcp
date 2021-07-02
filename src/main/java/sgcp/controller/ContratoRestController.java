package sgcp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sgcp.model.Contrato;
import sgcp.service.ContratoService;

@RestController
public class ContratoRestController {
	
	private final ContratoService cs;
	
	public ContratoRestController(ContratoService cs) {
		this.cs=cs;
	}
	
	@GetMapping("/api/contratos")
	public List<Contrato> listaContratos(){
		return cs.listaContratos();
	}

}
