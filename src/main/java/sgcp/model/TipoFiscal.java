package sgcp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tipo_fical")
@Data
public class TipoFiscal {

	
	@Id
	@Column(name="id_tipo_fiscal")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoFiscal;
	@Column(name="descricao")	
	private String descricao;
}
