package com.prueba.tecno.mapper;

import com.prueba.tecno.Dto.ClienteRequestDto;
import com.prueba.tecno.Dto.ClienteResponseDto;
import com.prueba.tecno.entity.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel ="spring")
public interface ClienteMap {

    Cliente DtoToCliente (ClienteRequestDto Dto);
    ClienteRequestDto ClienteToDto (Cliente cliente);

    ClienteResponseDto ClienteToResponseDto(Cliente cliente);
    List<ClienteResponseDto> ClienteToClienteResponseDto(List<Cliente>clientes);
}
