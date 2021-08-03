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
	
	
	private final TelefoneRepository telefoneRepository;
	private final TelefoneMapper mapper = TelefoneMapper.INSTANCE;
	

	public TelefoneService(TelefoneRepository telefoneRepository) {
		this.telefoneRepository = telefoneRepository;
	}
	public Telefone incluirTelefone(TelefoneDTO dto){	
		Telefone telefone = mapper.toModel(dto);
		return telefoneRepository.save(telefone);
	}
	public List<Telefone> listarTelefones() {	
		return telefoneRepository.findAll();
	}
	public Telefone alterarTelefone(TelefoneDTO telefoneDTO) {	
		Telefone telefone = mapper.toModel(telefoneDTO);
		return telefoneRepository.save(telefone);
	}
}
