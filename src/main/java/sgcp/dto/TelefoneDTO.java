package sgcp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

	private Integer id;
	
	private String cpf;
	
	//@Size(min=1, max=3)
	private Integer ddi;
	
	//@Size(min = 2, max = 3)
	private Integer ddd;
	
	//@NotEmpty
	//@Size(min=9, max=9)
	private Integer numero;
}
