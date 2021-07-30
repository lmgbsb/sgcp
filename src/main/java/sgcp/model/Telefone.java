package sgcp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "telefone")
public class Telefone {
	
	
	@Id
	@Column(name = "id_telefone")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;	
	private String cpf;	
	private Integer ddi;
	private Integer ddd;
	private Integer numero;
}
