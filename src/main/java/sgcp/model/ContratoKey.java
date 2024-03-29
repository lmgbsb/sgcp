package sgcp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.ToString;

@ToString
@Embeddable
public class ContratoKey implements Serializable{

	
	private static final long serialVersionUID = -9044521999239382757L;	
	@Column(name="numero_contrato")
	protected Integer numero;	
	@Column(name="ano_contrato")
	protected Integer ano;	
	
	
	public ContratoKey() {
		
	}	
	public ContratoKey(Integer numero, Integer ano) {
		this.ano=ano;
		this.numero=numero;
	}	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	@Override
	public int hashCode() {		
		final int prime = 31;
        int result = 1;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        result = prime * result + ((ano == null) ? 0 : ano.hashCode());
        return result;        
	}	
	public boolean equals(Object obj) {		
		if (this == obj) return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;		
		ContratoKey other = (ContratoKey) obj;
		return Objects.equals(numero, other.getNumero()) && Objects.equals(ano,other.getAno());	
	}    
}
