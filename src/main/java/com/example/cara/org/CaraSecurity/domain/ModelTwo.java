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
public class ModelTwo {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String patientId;

    private String prescriptionId;

    private String issueDate;

    private String printDate;

    private String issueId;

    private Long drugId;

    private Long uploadId;

    private int duration;

    private String atcOne;

    private int prescriptionType;

    private int scriptType;

    private String icdIndication;

    private String consultationId;

    private String userId;

    private String prescriptionDate;

    private String dob;

    private boolean active;

    private int patientType;

    private int gmsStatus;

    private String gender;

    private String abClassification;

    private String atcCode;

    private String levelFour;

    private int age;

}
