package com.prueba.tecno.service;

import com.prueba.tecno.Dto.VehiculoRequestDto;
import com.prueba.tecno.entity.Vehiculo;
import com.prueba.tecno.exceptions.ExceptionHelper;
import com.prueba.tecno.exceptions.Exceptions;
import com.prueba.tecno.mapper.VehiculoMap;
import com.prueba.tecno.repository.VehiculoRepository;
import com.prueba.tecno.security.JwtTokenProvider;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public ResponseEntity SaveCar(VehiculoRequestDto vehiculoRequestDto, String token) {
    {
            final Claims claims = jwtTokenProvider.decode(token);
            final Long userId = Long.parseLong(claims.get("Id").toString());

            if (!userId.equals(vehiculoRequestDto.getClienteId())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No está autorizado para registrar");
            }
                Vehiculo vehiculo = vehiculoMap.DtoToVehiculo(vehiculoRequestDto);
                vehiculoRepository.save(vehiculo);
                return ResponseEntity.ok("Vehiculo guardado con exito");
    }
    }

    public ResponseEntity<String> updateCar(Long id, VehiculoRequestDto vehiculoDto, String token) {

            Vehiculo vehiculo = vehiculoRepository.findById(id).orElse(null);
            final Claims claims = jwtTokenProvider.decode(token);
            final Long userId = Long.parseLong(claims.get("Id").toString());

            if (userId.equals(vehiculoDto.getClienteId())) {
              vehiculo = vehiculoMap.updateVehiculo(vehiculoDto, vehiculo);
               vehiculoRepository.save(vehiculo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Correcto");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No está autorizado para registrar");
            }
    }

    public ResponseEntity SearchCar(String matricula, String token)  {

        final Claims claims = jwtTokenProvider.decode(token);
        final Long userId = Long.parseLong(claims.get("Id").toString());

        Vehiculo vehiculo = vehiculoRepository.findByMatriculaAndId(matricula,userId);
        return ResponseEntity.ok(vehiculoMap.VehiculoToResponseDto(vehiculo));

    }

    public ResponseEntity ListCar(String token) {
        final Claims claims = jwtTokenProvider.decode(token);
        final Long userId = Long.parseLong(claims.get("Id").toString());
        List<Vehiculo> Vehiculos = vehiculoRepository.findAllByUserId(userId);
        return ResponseEntity.ok(vehiculoMap.VehiculoToVehiculoResponseDto(Vehiculos));
    }

    public ResponseEntity DeleteCar(Long id, String token) {
        final Claims claims = jwtTokenProvider.decode(token);
        final Long userId = Long.parseLong(claims.get("Id").toString());
        vehiculoRepository.deleteByIdAndClienteId(id,userId);
       return ResponseEntity.ok("Vehiculo eliminado");
    }

}
