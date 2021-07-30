package sgcp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgcp.model.DadosPessoais;
import sgcp.repository.PessoaRepository;

@Service
public class PessoaService {

	
	private final PessoaRepository pessoaRepository;
	
	
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}	
	public List<DadosPessoais> listarPessoas(){
		return pessoaRepository.findAll();
	}	
	public void IncluirPessoa(DadosPessoais p) {
		pessoaRepository.save(p);
	}
}
