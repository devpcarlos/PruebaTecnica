package com.prueba.tecno.service;

import com.prueba.tecno.Dto.AuthResponse;
import com.prueba.tecno.Helpers.ValidatorHelper;
import com.prueba.tecno.exceptions.NotValidException;
import com.prueba.tecno.entity.Cliente;
import com.prueba.tecno.repository.ClienteRepository;
import com.prueba.tecno.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Authservice {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity login(
            final String correo,
            final String password
    ) {
        // Validar que los campos no estén vacíos
        ValidatorHelper.assertNotNullNotEmpty(correo, "El email es obligatorio");
        ValidatorHelper.assertNotNullNotEmpty(password, "El password es obligatorio");

        // Buscar al usuario por su correo electrónico y contraseña
        final Cliente cliente = clienteRepository.findByEmailToLogin(correo.toLowerCase(), password );

        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Usuario o contraseña no coinciden");
        }

        final String token = jwtTokenProvider.generateToken(correo, cliente.getId(), cliente.getNombre());

        // Crear una instancia de AuthResponse y devolverla
        AuthResponse response = new AuthResponse(cliente.getNombre(), cliente.getApellido(), cliente.getCorreo(), token);
        return ResponseEntity.ok(response);
    }
}
