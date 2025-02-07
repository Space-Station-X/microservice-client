package com.practice.mappers;

import com.practice.RequestDto.ClientRequestDto;
import com.practice.ResponseDto.ClientCreateResponseDto;
import com.practice.ResponseDto.ClientResponseDto;
import com.practice.entity.ClientEntity;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class ClientMapper {
    private final ModelMapper modelMapper;

    public ClientMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ClientRequestDto toDto(ClientEntity client) {
        return modelMapper.map(client, ClientRequestDto.class);
    }

    public ClientResponseDto toDtoClient(ClientEntity client) {
        return modelMapper.map(client, ClientResponseDto.class);
    }
    public ClientCreateResponseDto toCreateResponseDto(ClientEntity client){
        return modelMapper.map(client,ClientCreateResponseDto.class);
    }
}
