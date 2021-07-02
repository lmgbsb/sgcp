package sgcp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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
	
	
	public ContratoKey getId() {
		return id;
	}
	public void setId(ContratoKey id) {
		this.id = id;
	}
	public String getObjeto() {
		return objeto;
	}
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	public Date getDataAssinatura() {
		return dataAssinatura;
	}
	public void setDataAssinatura(Date dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getProcessoContratacao() {
		return processoContratacao;
	}
	public void setProcessoContratacao(String processoContratacao) {
		this.processoContratacao = processoContratacao;
	}
	

	
	
}
