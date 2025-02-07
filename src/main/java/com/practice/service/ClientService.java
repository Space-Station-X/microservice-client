package com.practice.service;

import com.practice.RequestDto.ClientCreateRequestDto;
import com.practice.RequestDto.ClientUpdateRequestDto;
import com.practice.ResponseDto.ClientCreateResponseDto;
import com.practice.ResponseDto.ClientPageResponseDto;
import com.practice.ResponseDto.ClientResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

public interface ClientService {

    ClientPageResponseDto findAllClient(int page, int size);

    ClientCreateResponseDto createClient(ClientCreateRequestDto clientCreateRequestDto);

    ClientResponseDto findByClientId(Long id);

    ClientResponseDto updateClient(Long id, ClientUpdateRequestDto clientUpdateRequestDto);

    void deleteClient(Long id);
}
