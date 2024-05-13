package com.prueba.tecno.mapper;

import com.prueba.tecno.Dto.VehiculoRequestDto;
import com.prueba.tecno.Dto.VehiculoResponseDto;
import com.prueba.tecno.entity.Cliente;
import com.prueba.tecno.entity.Vehiculo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel ="spring", uses = {ClienteMap.class})
public interface VehiculoMap {
    @Mapping(source ="Dto.clienteId" ,target ="cliente.id" )
    Vehiculo DtoToVehiculo (VehiculoRequestDto Dto);

    @Mapping(source ="Dto.clienteId" ,target ="cliente.id" )
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    Vehiculo DtoToUpdate (VehiculoRequestDto Dto);

    VehiculoRequestDto VehiculoToDto (Vehiculo vehiculo);

    VehiculoResponseDto VehiculoToResponseDto(Vehiculo vehiculo);

    Vehiculo updateVehiculo(VehiculoRequestDto updateDto, @MappingTarget Vehiculo vehiculo);

    List<VehiculoResponseDto> VehiculoToVehiculoResponseDto(List<Vehiculo>vehiculos);
}
