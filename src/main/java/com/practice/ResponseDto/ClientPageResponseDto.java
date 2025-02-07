package com.practice.ResponseDto;

import com.practice.RequestDto.ClientRequestDto;

import java.util.List;

public record ClientPageResponseDto(
        List<ClientRequestDto> clientDto,
        int page,
        long totalElement
) {
}
