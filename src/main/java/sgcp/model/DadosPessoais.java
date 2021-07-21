package sgcp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name="dados_pessoais")
public class DadosPessoais {

	@Id
	@Column(name="cpf")
	private String cpf;
	@Column(name="nome")
	private String nome;
	private String email;
	private Date dataNascimento;
		
	
}
