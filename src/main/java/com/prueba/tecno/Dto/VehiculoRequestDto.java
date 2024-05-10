package com.prueba.tecno.Dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class VehiculoDto {
    private String marca;
    private int modelo;
    private LocalDateTime created;
    private LocalDateTime updated;;
}
