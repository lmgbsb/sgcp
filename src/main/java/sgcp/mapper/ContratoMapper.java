package sgcp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import sgcp.dto.ContratoDTO;
import sgcp.model.Contrato;
import sgcp.model.DadosPessoais;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ContratoMapper {

	
	public ContratoMapper INSTANCE = Mappers.getMapper(ContratoMapper.class);
	
	
	@Mapping(source = "dto.dataAssinatura", target = "dataAssinatura", dateFormat = "dd/MM/yyyy")
	@Mapping(source = "dto.numero", target = "id.numero")
	@Mapping(source = "dto.ano", target = "id.ano")
	@Mapping(source = "dto.cpfPreposto", target = "preposto.cpf")
	Contrato toModel(ContratoDTO dto);
}
