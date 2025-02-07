package com.practice.service;

import com.practice.Enums.EnumTypeDocument;
import com.practice.RequestDto.ClientCreateRequestDto;
import com.practice.RequestDto.ClientRequestDto;
import com.practice.RequestDto.ClientUpdateRequestDto;
import com.practice.ResponseDto.ClientCreateResponseDto;
import com.practice.ResponseDto.ClientPageResponseDto;
import com.practice.ResponseDto.ClientResponseDto;
import com.practice.entity.ClientEntity;
import com.practice.exceptions.ClientNotFoundException;
import com.practice.mappers.ClientMapper;
import com.practice.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Validated
public class ClientServiceImpl implements ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Override
    @Transactional(readOnly = true)
    public ClientPageResponseDto findAllClient(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ClientEntity> clientPage = clientRepository.findAll(pageable);
        List<ClientRequestDto> dto = clientPage.stream().map(
                clientMapper::toDto
        ).collect(Collectors.toList());
        return new ClientPageResponseDto(dto, clientPage.getTotalPages(), clientPage.getTotalElements());
    }

    @Override
    @Transactional(readOnly = true)
    public ClientResponseDto findByClientId(Long id) {
        ClientEntity client = clientRepository.findById(id).orElseThrow(() -> new
                ClientNotFoundException("Cliente con id " + id + " no encontrado"));
        return clientMapper.toDtoClient(client);
    }


    @Override
    @Transactional
    public ClientCreateResponseDto createClient(ClientCreateRequestDto clientCreateRequestDto) {
        EnumTypeDocument typeDocument;
        try {
            typeDocument = EnumTypeDocument.valueOf(clientCreateRequestDto.typeDocument());
        } catch (
                IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de notification Invalido");
        }

        ClientEntity client = ClientEntity
                .builder()
                .typeDocument(typeDocument)
                .numberDocument(clientCreateRequestDto.numberDocument())
                .numberDate(clientCreateRequestDto.numberDate())
                .registerDate(clientCreateRequestDto.registerDate())
                .isActive(clientCreateRequestDto.isActive())
                .phone(clientCreateRequestDto.phone())
                .email(clientCreateRequestDto.email())
                .build();
        clientRepository.save(client);
        return clientMapper.toCreateResponseDto(client);
    }

    @Transactional
    @Override
    public ClientResponseDto updateClient(Long id, ClientUpdateRequestDto clientUpdateRequestDto) {
        ClientEntity client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("No se encontró el cliente con id: " + id));

        updateClientFields(client, clientUpdateRequestDto);

        ClientEntity updatedClient = clientRepository.save(client);
        return clientMapper.toDtoClient(updatedClient);
    }

    @Transactional
    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException("Cliente con id " + id + " no existe");
        }
        clientRepository.deleteById(id);

    }

    private void updateClientFields(ClientEntity client, ClientUpdateRequestDto dto) {
        if (dto.typeDocument() != null) {
            client.setTypeDocument(validateTypeDocument(dto.typeDocument()));
        }
        if (dto.numberDocument() != null) {
            client.setNumberDocument(dto.numberDocument());
        }
        if (dto.numberDate() != null) {
            client.setNumberDate(dto.numberDate());
        }
        if (dto.registerDate() != null) {
            client.setRegisterDate(dto.registerDate());
        }
        if (dto.isActive() != null) {
            client.setIsActive(dto.isActive());
        }
        if (dto.phone() != null) {
            client.setPhone(dto.phone());
        }
        if (dto.email() != null) {
            client.setEmail(dto.email());
        }
    }

    private EnumTypeDocument validateTypeDocument(String typeDocument) {
        try {
            return EnumTypeDocument.valueOf(typeDocument);
        } catch (
                IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de documento inválido");
        }
    }
}
