package com.practice.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientCreateResponseDto {
    private Long id;
    private String typeDocument;
    private String numberDocument;
    private String numberDate;
    private LocalDate registerDate;
    private Integer isActive;
    private String phone;
    private String email;
}
