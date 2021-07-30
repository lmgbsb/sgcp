package sgcp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgcp.dto.DadosPessoaisDTO;
import sgcp.exception.DadosPessoaisNaoEncontradosException;
import sgcp.mapper.DadosPessoaisMapper;
import sgcp.model.DadosPessoais;
import sgcp.repository.DadosPessoaisRepository;

@Service
public class DadosPessoaisService {

	
	private final DadosPessoaisRepository dpr;
	private final DadosPessoaisMapper mapper = DadosPessoaisMapper.INSTANCE;
	
	
	public DadosPessoaisService(DadosPessoaisRepository dpr) {
		this.dpr = dpr;
	}
	public List<DadosPessoais> listarDadosPessoais() {	
		return dpr.findAll();
	}
	public DadosPessoais incluirDadosPessoais(DadosPessoaisDTO dto) {
		DadosPessoais dp = mapper.toModel(dto);		
		return dpr.save(dp);
	}
	public DadosPessoais alterarDadosPessoais(String cpf, DadosPessoaisDTO dto)  
			throws DadosPessoaisNaoEncontradosException {	
		
		verificaExistenciaDadosPessoais(cpf);
		DadosPessoais dp = mapper.toModel(dto);
		return dpr.save(dp);
	}
	public DadosPessoais detalharDadosPessoais(String cpf) throws DadosPessoaisNaoEncontradosException {
		DadosPessoais dp = verificaExistenciaDadosPessoais(cpf);					
		return dp;	
	}
	public void excluirDadosPessoais(String cpf) throws DadosPessoaisNaoEncontradosException {		
		verificaExistenciaDadosPessoais(cpf);		
		dpr.deleteById(cpf);
	}
	private DadosPessoais verificaExistenciaDadosPessoais(String cpf) throws DadosPessoaisNaoEncontradosException {	
		DadosPessoais dp = dpr.findById(cpf).orElseThrow(() -> new DadosPessoaisNaoEncontradosException(cpf));
		return dp;
	}
}
