package com.prueba.tecno.controller;

import com.prueba.tecno.Dto.VehiculoRequestDto;
import com.prueba.tecno.entity.Vehiculo;
import com.prueba.tecno.exceptions.Exception;
import com.prueba.tecno.exceptions.ExceptionHelper;
import com.prueba.tecno.service.VehiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping("/save")
    public ResponseEntity SaveCar (@Valid @RequestBody VehiculoRequestDto vehiculoRequestDto){
        vehiculoService.SaveCar(vehiculoRequestDto);
        return ResponseEntity.ok("Datos guardados con exito");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity UpdateCar(@Valid @PathVariable Long id, @RequestBody  VehiculoRequestDto vehiculoRequestDto) {

        ResponseEntity<String> responseEntity = vehiculoService.updateCar(id, vehiculoRequestDto);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }

    @GetMapping("/{matricula}")
    public ResponseEntity SearchCar(@PathVariable String matricula){

        return ResponseEntity.ok(vehiculoService.SearchCar(matricula));
    }

    @GetMapping
    public ResponseEntity ListCar(){
        return ResponseEntity.ok(vehiculoService.ListCar());
    }
}
