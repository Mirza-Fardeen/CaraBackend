package com.example.cara.org.CaraSecurity.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ModelOne {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int age;

    private String gender;

    private int patientType;

    private int gmsStatus;

    private String abAtConsult;

    private String icpcCodeFinal;

    private String icdCode;

    private String icpcCode;

    private String consultationDate;

    private String consultationId;

    private String patientId;

    private String levelFourFirst;


}
