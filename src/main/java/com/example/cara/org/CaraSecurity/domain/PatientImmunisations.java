package com.example.cara.org.CaraSecurity.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientImmunisations {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnore
    private Long id;

    private  String immunisationId;

    private String consultationId;

    private String icpcCode;

    private Date dateAdministered;

    private int doseId;

    private int drugId;

    private Date dateCreated;

    private Date dateModified;

    private String patientId;

    private String manufacturer;

    private  String agent;

    private String tradeName;

}
