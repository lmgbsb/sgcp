package sgcp.service;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import sgcp.model.Contrato;
import sgcp.model.ContratoKey;
import sgcp.repository.ContratoRepository;

@Service
public class ContratoService {

	private final ContratoRepository cr;

	private final MessageSource messages;
	
	public ContratoService(ContratoRepository cr, MessageSource messages) {
		
		this.cr = cr;
		this.messages = messages;
	}
	
	public List<Contrato> listaContratos(){
		return cr.findAll();
	}

	public String incluirContrato(Contrato contrato, Locale locale) {
		
		String responseMessage = null;
		
		if(!StringUtils.isEmpty(contrato)) {

			Contrato c = cr.save(contrato);			
			responseMessage = String.format(messages.getMessage("contrato.create.message",null,locale), c.toString());
		}

		System.out.println("Contrato incluído com sucesso");	
		return responseMessage;		
	}
	
	public String alterarContrato(Contrato contrato, Locale locale) {
		
		String responseMessage = null;
		
		if(!StringUtils.isEmpty(contrato)) {

			Contrato c = cr.save(contrato);			
			responseMessage = String.format(messages.getMessage("contrato.update.message",null,locale), c.toString());
		}

		System.out.println("Contrato alterado com sucesso");	
		return responseMessage;		
	}

	public String exluirContrato(ContratoKey ck, Locale locale) {
		
		String responseMessage = null;
		
		if(!StringUtils.isEmpty(ck)) {

			cr.deleteById(ck);			
			responseMessage = String.format(messages.getMessage("contrato.delete.message",null,locale), ck.toString());
		}

		System.out.println("Contrato excluído com sucesso");	
		return responseMessage;				
	}

	public Contrato detalharContrato(ContratoKey ck) {
		
		Contrato contrato =  cr.getById(ck);		
		return contrato;
	}
}
