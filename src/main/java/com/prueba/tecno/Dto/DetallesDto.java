package com.prueba.tecno.Dto;

import com.prueba.tecno.entity.Cliente;
import com.prueba.tecno.entity.Vehiculo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DetallesDto {
    private String matricula;
    private int kilometro;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDateTime updated;
}
