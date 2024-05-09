package com.prueba.tecno.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClienteDto {
    private String name;
    private String apellido;
    private String direccion;
    private String ciudad;
    private LocalDateTime updated;
}
