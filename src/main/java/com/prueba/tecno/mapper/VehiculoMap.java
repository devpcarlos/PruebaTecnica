package com.prueba.tecno.mapper;

import com.prueba.tecno.Dto.VehiculoRequestDto;
import com.prueba.tecno.Dto.VehiculoResponseDto;
import com.prueba.tecno.entity.Vehiculo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel ="spring", uses = {ClienteMap.class})
public interface VehiculoMap {
    @Mapping(source ="clienteId" ,target ="cliente.id" )
    Vehiculo DtoToVehiculo (VehiculoRequestDto Dto);

    VehiculoRequestDto VehiculoToDto (Vehiculo vehiculo);

    VehiculoResponseDto VehiculoToResponseDto(Vehiculo vehiculo);

    void updateVehiculoToDto(VehiculoRequestDto vehiculoRequestDto, @MappingTarget Vehiculo vehiculo);
    List<VehiculoResponseDto> VehiculoToVehiculoResponseDto(List<Vehiculo>vehiculos);
}
