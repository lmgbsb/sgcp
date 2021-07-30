package sgcp.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import sgcp.model.Vigencia;

@Data
public class ContratoDTO {
	
	
    private String numero;
    private String ano;
	private String objeto;	
	@NotNull
	private String dataAssinatura;	
	private String valor;	
	@Pattern(regexp=".+\\/+\\d{4}$", message = "Processo de contratação deve ser válido")
	private String processoContratacao;	
	private List<Vigencia> vigencias;
}
