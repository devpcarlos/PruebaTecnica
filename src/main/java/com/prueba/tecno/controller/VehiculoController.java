package com.prueba.tecno.controller;

import com.prueba.tecno.Dto.VehiculoRequestDto;
import com.prueba.tecno.service.VehiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping("/save")
    public ResponseEntity SaveCar (@Valid @RequestBody VehiculoRequestDto vehiculoRequestDto,
                                   @RequestHeader ("Authorization") String token)  {
        return ResponseEntity.ok(vehiculoService.SaveCar(vehiculoRequestDto, token));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity UpdateCar( @PathVariable Long id, @Valid @RequestBody  VehiculoRequestDto vehiculoRequestDto,
                                    @RequestHeader ("Authorization") String token) {
        return ResponseEntity.ok(vehiculoService.updateCar(id, vehiculoRequestDto, token));
    }

    @GetMapping("/{matricula}")
    public ResponseEntity SearchCar(@PathVariable String matricula,
                                    @RequestHeader ("Authorization") String token) {
        return ResponseEntity.ok(vehiculoService.SearchCar(matricula, token));
    }

    @GetMapping
    public ResponseEntity ListCar( @RequestHeader ("Authorization") String token) {
        return ResponseEntity.ok(vehiculoService.ListCar(token));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteCar(@PathVariable Long id,
                                    @RequestHeader ("Authorization") String token) {

        return ResponseEntity.ok(vehiculoService.DeleteCar(id, token));
    }
}
