package sgcp.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;
import sgcp.model.Vigencia;

@Data
public class ContratoDTO {
	
	
    private String numero;
    private String ano;
	private String objeto;	
	@NotNull
	@Pattern(regexp="\\d{2}+\\/\\d{2}+\\/\\d{4}$", message = "Informe a data no formato dd/mm/aaaa")
	private String dataAssinatura;	
	private String valor;	
	@Pattern(regexp=".+\\/+\\d{4}$", message = "Processo de contratação deve ser válido")
	private String processoContratacao;	
	@CPF
	private String cpfPreposto;
	private List<Vigencia> vigencias;
}
