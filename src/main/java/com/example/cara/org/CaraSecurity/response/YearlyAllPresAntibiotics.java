package com.example.cara.org.CaraSecurity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YearlyAllPresAntibiotics {
    private long allPrescriptions;
    private long allPrescripAntibiotics;
}
