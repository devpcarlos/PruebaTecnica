package com.prueba.tecno.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDto {

    @NotBlank(message = "El campo nombre no puede estar vacio")
    private String nombre;
    @NotBlank(message = "El campo apellido no puede estar vacio")
    private String apellido;
    @NotBlank(message = "El campo celular no puede estar vacio")
    private String celular;
    @NotBlank(message = "El campo Email no puede estar vacio")
    @Email(message = "Debe ser un correo valido")
    private String correo;
    @NotBlank(message = "El campo contraseña no puede estar vacio")
    @Size(min = 8,max = 255, message = "La contraseña debe tener un minimo de 8 y un maximo de 20")
    private String password;
}
