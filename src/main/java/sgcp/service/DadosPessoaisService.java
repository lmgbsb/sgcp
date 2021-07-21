package sgcp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import sgcp.model.DadosPessoais;
import sgcp.repository.DadosPessoaisRepository;

@Service
public class DadosPessoaisService {

	private final DadosPessoaisRepository dpr;
	
	public DadosPessoaisService(DadosPessoaisRepository dpr) {
		this.dpr = dpr;
	}

	public List<DadosPessoais> listarDadosPessoais() {
		
		return dpr.findAll();
		
	}

	public DadosPessoais incluirDadosPessoais(DadosPessoais dp) {

		return dpr.save(dp);
	}

	public void excluirDadosPessoais(String cpf) {
		
		dpr.deleteById(cpf);
		
	}

	public DadosPessoais alterarDadosPessoais(DadosPessoais dp) {
		
		return dpr.save(dp);
		
	}

	public Optional<DadosPessoais> detalharDadosPessoais(String cpf) {
		
		return dpr.findById(cpf);
		
	}
}
