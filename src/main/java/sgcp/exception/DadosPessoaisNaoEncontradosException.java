package sgcp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DadosPessoaisNaoEncontradosException extends Exception {
	
	
	public DadosPessoaisNaoEncontradosException (String cpf) {	
		super("Dados pessoais não encontrados para o CPF " + cpf);
	}
}
