package sgcp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name="dados_pessoais")
public class DadosPessoais extends RepresentationModel<DadosPessoais>{
	
	
	@Id
	@Column(name="cpf")
	private String cpf;
	@Column(name="nome")
	private String nome;
	private String email;	
	private LocalDate dataNascimento;		
	@OneToMany(mappedBy="cpf")
	private List<Telefone> telefones;
}
