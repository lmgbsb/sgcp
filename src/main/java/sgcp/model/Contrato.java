package sgcp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
@Entity
@Table(name="contrato")
public class Contrato {
	
	@EmbeddedId
    private ContratoKey id;
	
	@Column(name="objeto")
	private String objeto;
	
	@Column(name="data_assinatura")
	private Date dataAssinatura;
	
	@Column(name="valor")
	private float valor;
	
	private String processoContratacao;
	
	@OneToMany(mappedBy="contrato")
	private List<Vigencia> vigencias;
	
}
