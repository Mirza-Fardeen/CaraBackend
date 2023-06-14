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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionsIssue {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    private String issueId;

    private String drugId;

    private String prescriptionId;

    private Date issueDate;

    private int printCount;

    private int duration;

    private int quantity;

    private String userId;

    private String strength;

    private String form;

    private String tradeName;

    private String mainIngredient;

    private String packSizeNum;

    private String printedDate;

    private String dateCreated;

    private String dateModified;

    private  String atcOne;

}
