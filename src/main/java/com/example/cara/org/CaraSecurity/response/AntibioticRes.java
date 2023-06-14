package com.example.cara.org.CaraSecurity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AntibioticRes {

    private long numberOfantibiotics;

    private long averageYear;

    private long percYear;

    private long threeDays;

}