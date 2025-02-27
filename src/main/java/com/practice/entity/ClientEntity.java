package com.practice.entity;

import com.practice.Enums.EnumTypeDocument;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
@Builder
@Entity
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type_document")
    @Enumerated(EnumType.STRING)
    private EnumTypeDocument typeDocument;
    @Column(name = "nro_document")
    private String numberDocument;
    @Column(name = "nro_date")
    private String numberDate;
    @Column(name = "register_date")
    @Builder.Default
    private LocalDate registerDate = LocalDate.now();
    @Column(name = "is_active")
    private Integer isActive;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;


}
