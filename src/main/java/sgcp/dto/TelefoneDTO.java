package sgcp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TelefoneDTO {

	private Integer id;
	
	private String cpf;
	
	@Size(min=1, max=3)
	private String ddi;
	
	@Size(min = 2, max = 3)
	private String ddd;
	
	@NotEmpty
	@Size(min=8, max=9)
	private String numero;
}
