package sgcp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import sgcp.dto.ContratoDTO;
import sgcp.model.Contrato;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface ContratoMapper {

	
	public ContratoMapper INSTANCE = Mappers.getMapper(ContratoMapper.class);
	
	
	@Mapping(source = "dto.dataAssinatura", target = "dataAssinatura", dateFormat = "dd/MM/yyyy")
	@Mapping(source = "dto.numero", target = "id.numero")
	@Mapping(source = "dto.ano", target = "id.ano")
	@Mapping(source = "dto.cpfPreposto", target = "preposto.cpf")
	Contrato toModel(ContratoDTO dto);
}
