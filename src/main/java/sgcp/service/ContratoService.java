package sgcp.service;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import sgcp.dto.ContratoDTO;
import sgcp.mapper.ContratoMapper;
import sgcp.model.Contrato;
import sgcp.model.ContratoKey;
import sgcp.repository.ContratoRepository;

@Service
public class ContratoService {

	
	private final ContratoRepository contratoRepository;
	private final MessageSource messages;
	private ContratoMapper mapper = ContratoMapper.INSTANCE;
	
	
	public ContratoService(ContratoRepository contratoRepository, MessageSource messages) {		
		this.contratoRepository = contratoRepository;
		this.messages = messages;
	}	
	public List<Contrato> listaContratos(){
		return contratoRepository.findAll();
	}
	/*
	public String incluirContrato(Contrato contrato, Locale locale) {		
		String responseMessage = null;		
		if(!StringUtils.isEmpty(contrato)) {
			Contrato c = contratoRepository.save(contrato);			
			responseMessage = String.format(messages.getMessage("contrato.contratoRepositoryeate.message",null,locale), c.toString());
		}
		System.out.println("Contrato incluído com sucesso");	
		return responseMessage;		
	}
	*/
	public Contrato incluirContrato(ContratoDTO contratoDTO) {
		Contrato contrato = mapper.toModel(contratoDTO);
		if(contratoDTO.getCpfPreposto() == null) {
			contrato.setPreposto(null);
		}
		return contratoRepository.save(contrato);
	}	
	public String alterarContrato(Contrato contrato, Locale locale) {
		String responseMessage = null;
		if(!StringUtils.isEmpty(contrato)) {
			Contrato c = contratoRepository.save(contrato);			
			responseMessage = String.format(messages.getMessage("contrato.update.message",null,locale), c.toString());
		}
		System.out.println("Contrato alterado com sucesso");	
		return responseMessage;		
	}
	public String exluirContrato(ContratoKey ck, Locale locale) {	
		String responseMessage = null;
		if(!StringUtils.isEmpty(ck)){
			contratoRepository.deleteById(ck);			
			responseMessage = String.format(messages.getMessage("contrato.delete.message",null,locale), ck.toString());
		}
		System.out.println("Contrato excluído com sucesso");	
		return responseMessage;				
	}
	public Contrato detalharContrato(ContratoKey ck){	
		Contrato contrato =  contratoRepository.getById(ck);		
		return contrato;
	}
}
