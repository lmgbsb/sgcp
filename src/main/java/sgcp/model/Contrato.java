package sgcp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
