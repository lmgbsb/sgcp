package sgcp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import sgcp.dto.DadosPessoaisDTO;
import sgcp.model.DadosPessoais;

//@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DadosPessoaisMapper {

	
	DadosPessoaisMapper INSTANCE = Mappers.getMapper(DadosPessoaisMapper.class);	
	
	
	@Mapping(source = "dto.dataNascimento", target = "dataNascimento", dateFormat = "dd/MM/yyyy")
	DadosPessoais toModel(DadosPessoaisDTO dto);
}
