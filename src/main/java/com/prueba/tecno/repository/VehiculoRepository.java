package com.prueba.tecno.repository;

import com.prueba.tecno.entity.Vehiculo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository  extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v FROM vehiculo v WHERE v.cliente.id = :userId AND v.matricula = :matricula")
    Vehiculo findByMatriculaAndId(String matricula, Long userId);

    @Query("SELECT v FROM vehiculo v WHERE v.cliente.id = :userId")
    List<Vehiculo> findAllByUserId(Long userId);

    @Transactional
    Long deleteByIdAndClienteId(Long id, Long clienteId);

}
