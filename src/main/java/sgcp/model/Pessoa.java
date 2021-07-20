package sgcp.model;

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
@Table(name="pessoa")
public class Pessoa {

	@Id
	@Column(name="cpf")
	private String cpf;
	@Column(name="nome")
	private String nome;
	private String email;
	private String dataNascimento;
		
	
}
