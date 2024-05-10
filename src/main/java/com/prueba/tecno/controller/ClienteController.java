package com.prueba.tecno.controller;

import com.prueba.tecno.Dto.ClienteRequestDto;
import com.prueba.tecno.Dto.ClienteResponseDto;
import com.prueba.tecno.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<?> register(@Valid @RequestBody ClienteRequestDto clienteRequestDto){
        clienteService.createCliente(clienteRequestDto);
        return ResponseEntity.ok("Cliente Guardado con exito");
    }

    @GetMapping("/{correo}")
    public ClienteResponseDto GetCorreo(@PathVariable String correo){
      return clienteService.GetCorreo(correo);
    }
}
