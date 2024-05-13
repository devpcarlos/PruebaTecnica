package com.prueba.tecno.service;

import com.prueba.tecno.Dto.ClienteRequestDto;
import com.prueba.tecno.Dto.ClienteResponseDto;
import com.prueba.tecno.entity.Cliente;
import com.prueba.tecno.mapper.ClienteMap;
import com.prueba.tecno.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMap clienteMap;

    @Transactional
    public ResponseEntity<String> createCliente(ClienteRequestDto clienteRequestDto) {
        String encryptedPassword = clienteRepository.encryptPassword(clienteRequestDto.getPassword());
        clienteRequestDto.setPassword(encryptedPassword);

        Cliente cliente = clienteMap.DtoToCliente(clienteRequestDto);
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado con éxito");
    }

    public ResponseEntity AllCliente(){
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clienteMap.ClienteToClienteResponseDto(clientes));
    }
}
