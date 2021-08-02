package sgcp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private LocalDate dataAssinatura;	
	@Column(name="valor")
	private double valor;	
	private String processoContratacao;	
	@OneToMany(mappedBy="contrato")
	private List<Vigencia> vigencias;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "preposto",
    	joinColumns = { 
    			@JoinColumn(name = "numero_contrato", referencedColumnName = "numero_contrato"),
        		@JoinColumn(name = "ano_contrato", referencedColumnName = "ano_contrato")},
    	inverseJoinColumns = { @JoinColumn(name = "cpf", referencedColumnName = "cpf") })
	private DadosPessoais preposto;
}
