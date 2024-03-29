package sgcp.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sgcp.dto.TelefoneDTO;
import sgcp.model.Telefone;

@Mapper
public interface TelefoneMapper {
	
	
	TelefoneMapper INSTANCE = Mappers.getMapper(TelefoneMapper.class);	
	
	
	Telefone toModel(TelefoneDTO telefoneDTO);	
}
