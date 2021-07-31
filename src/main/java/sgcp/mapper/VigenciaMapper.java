package sgcp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import sgcp.dto.VigenciaDTO;
import sgcp.model.Vigencia;

@Mapper
public interface VigenciaMapper {

	public final VigenciaMapper INSTANCE = Mappers.getMapper(VigenciaMapper.class);
	
	@Mapping(source = "dto.numeroContrato", target = "contrato.numero")
	@Mapping(source = "dto.anoContrato", target = "contrato.ano")
	@Mapping(source = "dto.dataInicio", target = "dataInicio", dateFormat = "dd/MM/yyyy")
	@Mapping(source = "dto.dataFim", target = "dataFim", dateFormat = "dd/MM/yyyy")
	Vigencia toModel(VigenciaDTO dto);
}
