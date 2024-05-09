package com.prueba.tecno.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String apellido;
    private String direccion;
    private String ciudad;
    private LocalDateTime craeted;
    private LocalDateTime updated;
}