package com.prueba.tecno.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoResponseDto {
    private String marca;
    private int modelo;
    private String matricula;
    private int kilometro;
}
