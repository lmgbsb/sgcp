package sgcp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgcp.model.Vigencia;
import sgcp.repository.VigenciaRepository;

@Service
public class VigenciaService {
	
	
	private VigenciaRepository vigenciaRepository;
	
	
	public VigenciaService(VigenciaRepository vigenciaRepository) {
		this.vigenciaRepository = vigenciaRepository;
	}
	public List<Vigencia> listarVigencias(){
		return vigenciaRepository.findAll();
	}
	public Vigencia incluirVigencia(Vigencia vigencia) {
		return vigenciaRepository.save(vigencia);
	}
	public Vigencia alterarVigencia(Vigencia vigencia) {	
		return vigenciaRepository.save(vigencia);
	}
	public void excluirVigencia(Integer idVigencia) {	
		vigenciaRepository.deleteById(idVigencia);
	}
}
