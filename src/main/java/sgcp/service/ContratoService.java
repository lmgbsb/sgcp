package sgcp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgcp.model.Contrato;
import sgcp.repository.ContratoRepository;

@Service
public class ContratoService {

	private final ContratoRepository cr;
	
	public ContratoService(ContratoRepository cr) {
		
		this.cr = cr;
	}
	
	public List<Contrato> listaContratos(){
		return cr.findAll();
	}
}
