package com.practice.RequestDto;

import java.time.LocalDate;

public record ClientUpdateRequestDto(
        Long id,
        String typeDocument,
        String numberDocument,
        String numberDate,
        LocalDate registerDate,
        Integer isActive,
        String phone,
        String email) {
}
