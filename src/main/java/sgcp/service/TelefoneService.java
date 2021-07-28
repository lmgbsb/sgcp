package sgcp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import sgcp.dto.TelefoneDTO;
import sgcp.mapper.TelefoneMapper;
import sgcp.model.Telefone;
import sgcp.repository.TelefoneRepository;

@Service
public class TelefoneService {
	
	private final TelefoneRepository tr;
	private final TelefoneMapper mapper = TelefoneMapper.INSTANCE;
	

	public TelefoneService(TelefoneRepository tr) {
		this.tr = tr;
	}
	
	public Telefone incluirTelefone(@RequestBody Telefone phone){
		
		return tr.save(phone);
		
	}

	public List<Telefone> listarTelefones() {
		
		return tr.findAll();
		
	}

	public Telefone alterarTelefone(TelefoneDTO telefoneDTO) {
		
		Telefone telefone = mapper.toModel(telefoneDTO);
		
		return tr.save(telefone);
		
	}
}
