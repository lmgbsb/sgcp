package sgcp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import sgcp.model.Telefone;
import sgcp.repository.TelefoneRepository;

@Service
public class TelefoneService {
	
	private final TelefoneRepository tr;
	

	public TelefoneService(TelefoneRepository tr) {
		this.tr = tr;
	}
	
	public Telefone incluirTelefone(@RequestBody Telefone phone){
		
		return tr.save(phone);
		
	}

	public List<Telefone> listarTelefones() {
		
		return tr.findAll();
		
	}
}
