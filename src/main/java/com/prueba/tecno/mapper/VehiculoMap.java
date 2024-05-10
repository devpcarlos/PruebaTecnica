package com.prueba.tecno.mapper;

import com.prueba.tecno.Dto.VehiculoRequestDto;
import com.prueba.tecno.Dto.VehiculoResponseDto;
import com.prueba.tecno.entity.Vehiculo;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel ="spring")
public interface VehiculoMap {
    Vehiculo DtoToVehiculo (VehiculoRequestDto Dto);
    VehiculoRequestDto VehiculoToDto (Vehiculo vehiculo);

    VehiculoResponseDto VehiculoToResponseDto(Vehiculo vehiculo);
    List<VehiculoResponseDto> VehiculoToVehiculoResponseDto(List<Vehiculo>vehiculos);
}
