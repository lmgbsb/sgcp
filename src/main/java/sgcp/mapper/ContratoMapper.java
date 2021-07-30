package sgcp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import sgcp.dto.ContratoDTO;
import sgcp.model.Contrato;

@Mapper
public interface ContratoMapper {

	
	public ContratoMapper INSTANCE = Mappers.getMapper(ContratoMapper.class);
	@Mapping(target = "dataAssinatura", source = "dto.dataAssinatura", dateFormat = "dd/MM/yyyy")
	@Mapping(target = "id.numero", source = "dto.numero")
	@Mapping(target = "id.ano", source = "dto.ano")
	Contrato toModel(ContratoDTO dto);
	ContratoDTO toDTO(Contrato contrato);
}
