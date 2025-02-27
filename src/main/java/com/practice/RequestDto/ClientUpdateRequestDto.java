package com.practice.RequestDto;

import java.time.LocalDate;

public record ClientUpdateRequestDto(
        String typeDocument,
        String numberDocument,
        String numberDate,
        LocalDate registerDate,
        Integer isActive,
        String phone,
        String email) {
}
