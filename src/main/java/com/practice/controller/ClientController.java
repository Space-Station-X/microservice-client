package com.practice.controller;

import com.practice.RequestDto.*;
import com.practice.ResponseDto.*;
import com.practice.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
@Validated
@Tag(name = "Clientes", description = "Clientes  API")
public class ClientController {
    private final ClientService clientService;

    @Operation(summary = "Obtener todo los clientes", description = "Devuelve todo los clientes")
    @ApiResponse(responseCode = "200", description = "Clientes obtenidos correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron clientes")
    @GetMapping("")
    public ResponseEntity<ClientPageResponseDto> findAllClients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        ClientPageResponseDto response = clientService.findAllClient(page, size);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Obtener  cliente por ID", description = "Devuelve cliente por ID")
    @ApiResponse(responseCode = "200", description = "Cliente obtenidos correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró el cliente")
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> findByClientId(@PathVariable Long id) {
        ClientResponseDto response = clientService.findByClientId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Crear un cliente", description = "Crea  un  cliente")
    @ApiResponse(responseCode = "200", description = "Cliente creado correctamente")
    @ApiResponse(responseCode = "404", description = "No se pudo crear el cliente")
    @PostMapping("")
    public ResponseEntity<ClientCreateResponseDto> createClient(@RequestBody @Valid ClientCreateRequestDto clientCreateRequestDto) {
        ClientCreateResponseDto response = clientService.createClient(clientCreateRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualiza un cliente", description = "Actualiza  un cliente por ID")
    @ApiResponse(responseCode = "200", description = "Cliente actualizado correctamente")
    @ApiResponse(responseCode = "404", description = "No se pudo actualizar el cliente")
    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> updateClientById(@PathVariable Long id, @RequestBody @Valid ClientUpdateRequestDto clientUpdateRequestDto) {
        ClientResponseDto response = clientService.updateClient(id, clientUpdateRequestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Elimina un cliente por ID", description = "Elimina un cliente por ID")
    @ApiResponse(responseCode = "200", description = "Cliente eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró el cliente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByClientId(@PathVariable Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
