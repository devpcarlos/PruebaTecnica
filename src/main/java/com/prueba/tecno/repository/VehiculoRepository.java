package com.prueba.tecno.repository;

import com.prueba.tecno.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository  extends JpaRepository<Vehiculo, Long> {

    Vehiculo findByMatricula(String matricula);git 
}
