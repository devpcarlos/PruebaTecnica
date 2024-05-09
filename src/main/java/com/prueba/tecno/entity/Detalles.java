package com.prueba.tecno.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "detalles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Detalles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricula;
    private int kilometro;
    private LocalDateTime craeted;
    private LocalDateTime updated;
    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;
}
