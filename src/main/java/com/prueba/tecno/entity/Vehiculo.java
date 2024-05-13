package com.prueba.tecno.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "vehiculo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private int modelo;
    private String matricula;
    private int kilometro;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    @ManyToOne
    @JoinColumn(name = "Id_cliente")
    private Cliente cliente;
}
