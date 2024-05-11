package com.prueba.tecno.service;

import com.prueba.tecno.Dto.VehiculoRequestDto;
import com.prueba.tecno.entity.Vehiculo;
import com.prueba.tecno.exceptions.CustomException;
import com.prueba.tecno.mapper.VehiculoMap;
import com.prueba.tecno.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private VehiculoMap vehiculoMap;


    public ResponseEntity SaveCar(VehiculoRequestDto vehiculoRequestDto) {

        Vehiculo vehiculo = vehiculoMap.DtoToVehiculo(vehiculoRequestDto);
        vehiculoRepository.save(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vehiculo guardado con exito");
    }

    public ResponseEntity<String> updateCar( Long id, VehiculoRequestDto vehiculoDto) {
        try {
            Vehiculo vehiculo = vehiculoRepository.findById(id).orElse(null); // Busca el vehículo por ID
            if (vehiculo == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehiculo con ID " + id + " no encontrado");
            } vehiculoMap.updateVehiculoToDto(vehiculoDto, vehiculo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Correcto");
        }catch (CustomException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
        }

    public ResponseEntity SearchCar(String matricula) {

        Vehiculo vehiculo = vehiculoRepository.findByMatricula(matricula);
        return ResponseEntity.ok(vehiculoMap.VehiculoToResponseDto(vehiculo));
    }

    public ResponseEntity ListCar() {
        List<Vehiculo> Vehiculos = vehiculoRepository.findAll();
        return ResponseEntity.ok(vehiculoMap.VehiculoToVehiculoResponseDto(Vehiculos));
    }
}
