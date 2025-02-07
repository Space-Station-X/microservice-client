package com.practice.RequestDto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "")
public class ClientRequestDto {
    private Long id;
    private String typeDocument;
    private String numberDocument;
    private String numberDate;
    private LocalDate registerDate;
    private Integer isActive;
    private String phone;
    private String email;
}
