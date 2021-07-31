package sgcp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class VigenciaDTO {

	
	private String id;
	private String numeroContrato;
	private String anoContrato;
	@NotNull
	@Pattern(regexp="\\d{2}+\\/\\d{2}+\\/\\d{4}$", message = "Informe a data no formato dd/mm/aaaa")
	private String dataInicio;
	@NotNull
	@Pattern(regexp="\\d{2}+\\/\\d{2}+\\/\\d{4}$", message = "Informe a data no formato dd/mm/aaaa")
	private String dataFim;
}
