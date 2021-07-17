package sgcp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgcp.model.Vigencia;
import sgcp.repository.VigenciaRepository;

@Service
public class VigenciaService {
	
	private VigenciaRepository vr;
	
	public VigenciaService(VigenciaRepository vr) {
		
		this.vr = vr;
		
	}
	
	public List<Vigencia> listarVigencias(){
		return vr.findAll();
	}

	public Vigencia incluirVigencia(Vigencia vigencia) {
		return vr.save(vigencia);
	}

}
