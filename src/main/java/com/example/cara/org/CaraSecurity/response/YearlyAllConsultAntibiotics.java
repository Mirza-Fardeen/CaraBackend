package com.example.cara.org.CaraSecurity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YearlyAllConsultAntibiotics {

    private long allConsultations;

    private long allConsultAntibiotics;

//    private long allPrescriptions;
//
//    private long allPrescripAntibiotics;
}
