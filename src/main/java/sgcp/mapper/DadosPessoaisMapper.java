package sgcp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import sgcp.dto.DadosPessoaisDTO;
import sgcp.model.DadosPessoais;

@Mapper
public interface DadosPessoaisMapper {

	DadosPessoaisMapper INSTANCE = Mappers.getMapper(DadosPessoaisMapper.class);
	
	@Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd/MM/yyyy")
	DadosPessoais toModel(DadosPessoaisDTO dadosPessoaisDTO);
	DadosPessoaisDTO toDTO(DadosPessoais dadosPessoais);
	
}
