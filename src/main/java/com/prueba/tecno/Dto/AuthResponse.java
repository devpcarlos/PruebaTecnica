package com.prueba.tecno.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String nombre;
    private String apellido;
    private String email;
    private String token;
}
