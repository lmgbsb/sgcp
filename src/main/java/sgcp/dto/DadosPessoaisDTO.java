package sgcp.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;
import sgcp.model.Telefone;

@Data
public class DadosPessoaisDTO {
	
	
	@CPF
	private String cpf;	
	@NotEmpty
    @Size(min = 2, max = 100)
	private String nome;
	@Email(message = "Email deve ser válido")
	@Pattern(regexp=".+@.+\\..+", message = "Email deve ser válido")
	private String email;	
	@NotNull
	private String dataNascimento;		
	@Valid
	private List<Telefone> telefones;
}
