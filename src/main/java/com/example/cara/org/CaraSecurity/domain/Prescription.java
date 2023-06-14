package com.example.cara.org.CaraSecurity.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Prescription {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    private String prescriptionId;

    private String consultationId;

    private Date prescriptionDate;

    private Date dateCreated;

    private Date dateModified;

    private int prescriptionType;

    private int scriptType;

    private String userId;

    private String patientId;

}