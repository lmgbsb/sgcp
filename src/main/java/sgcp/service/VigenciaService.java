package sgcp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgcp.dto.VigenciaDTO;
import sgcp.mapper.VigenciaMapper;
import sgcp.model.Vigencia;
import sgcp.repository.VigenciaRepository;

@Service
public class VigenciaService {
	
	
	private VigenciaRepository vigenciaRepository;
	private VigenciaMapper mapper = VigenciaMapper.INSTANCE;
	
	
	public VigenciaService(VigenciaRepository vigenciaRepository) {
		this.vigenciaRepository = vigenciaRepository;
	}
	public Vigencia incluirVigencia(VigenciaDTO vigenciaDTO) {
		Vigencia vigencia = mapper.toModel(vigenciaDTO);
		return vigenciaRepository.save(vigencia);
	}
	public List<Vigencia> listarVigencias(){
		return vigenciaRepository.findAll();
	}
	public Vigencia alterarVigencia(Vigencia vigencia) {	
		return vigenciaRepository.save(vigencia);
	}
	public void excluirVigencia(Integer idVigencia) {	
		vigenciaRepository.deleteById(idVigencia);
	}
}
