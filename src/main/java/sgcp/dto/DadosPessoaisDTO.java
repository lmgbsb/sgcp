package sgcp.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.Valid;

import sgcp.model.Telefone;

public class DadosPessoaisDTO {

	private String cpf;
	private String nome;
	private String email;
	private Date dataNascimento;
		
	@Valid
	@OneToMany(mappedBy="cpf")
	private List<Telefone> telefones;
}
