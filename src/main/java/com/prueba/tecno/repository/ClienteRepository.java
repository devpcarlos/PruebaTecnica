package com.prueba.tecno.repository;

import com.prueba.tecno.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT crypt(?1, gen_salt('bf'))", nativeQuery = true)
    String encryptPassword(String password);

    Cliente findByCorreo(String correo);

    @Query(value = "SELECT * " + "FROM Cliente c " +
            "WHERE c.correo = :correo " +
            "AND c.password = crypt(:password, c.password)",
            nativeQuery = true)
    Cliente findByEmailToLogin(@Param("correo") String correo,
                               @Param("password") String password);
}
