package sgcp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgcp.model.Contrato;
import sgcp.model.ContratoKey;
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

	public Contrato incluirContrato(Contrato contrato) {
		
		
		System.out.println("Contrato incluído com sucesso");
		return cr.save(contrato);
		
	}

	public void exluirContrato(ContratoKey ck) {
		
		cr.deleteById(ck);
		
	}

	public Contrato alterarContrato(Contrato contrato) {
		
		return cr.save(contrato);
	}

	public Contrato detalharContrato(ContratoKey ck) {
		
		Contrato contrato =  cr.getById(ck);
		
		return contrato;
	}
}
