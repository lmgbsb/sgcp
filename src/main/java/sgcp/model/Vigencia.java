package sgcp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name="vigencia")
public class Vigencia {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_vigencia")
	private Integer id;
	private ContratoKey contrato;
	@Column(name="data_inicio")
	private LocalDate dataInicio;
	@Column(name="data_fim")
	private LocalDate dataFim;
}
