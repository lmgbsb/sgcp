package sgcp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgcp.model.Pessoa;
import sgcp.repository.PessoaRepository;

@Service
public class PessoaService {

	private final PessoaRepository pr;
	
	public PessoaService(PessoaRepository pr) {
		this.pr = pr;
	}
	
	public List<Pessoa> listarPessoas(){
		return pr.findAll();
	}
	
	public void IncluirPessoa(Pessoa p) {
		pr.save(p);
	}
}
