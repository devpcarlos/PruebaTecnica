package com.prueba.tecno.Dto;

import com.prueba.tecno.entity.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoRequestDto {
    @NotBlank(message = "El campo marca no puede estar vacio")
    private String marca;
    @NotNull(message = "El campo modelo no puede estar vacio")
    private int modelo;
    @NotBlank(message = "El campo matricula no puede estar vacio")
    private String matricula;
    @NotNull(message = "El campo kilometro no puede estar vacio")
    private int kilometro;
    @NotBlank(message = "El campo cliente no puede estar vacio")
    private Cliente cliente;
}
