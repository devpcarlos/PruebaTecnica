package com.prueba.tecno.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDto {

    private String nombre;
    private String apellido;
    private String celular;
    private String correo;

}


