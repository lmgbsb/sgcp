package sgcp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	
}
