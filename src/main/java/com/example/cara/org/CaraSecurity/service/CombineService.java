package com.example.cara.org.CaraSecurity.service;


import com.example.cara.org.CaraSecurity.domain.ModelOne;
import com.example.cara.org.CaraSecurity.domain.ModelTwo;
import com.example.cara.org.CaraSecurity.repository.ModelOneRepo;
import com.example.cara.org.CaraSecurity.repository.ModelTwoRepo;
import com.example.cara.org.CaraSecurity.response.YearlyAllConsultAntibiotics;
import com.example.cara.org.CaraSecurity.response.YearlyAllPresAntibiotics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CombineService {


    @Autowired
    private ModelOneRepo modelOneRepo;

    @Autowired
    private ModelTwoRepo modelTwoRepo;

    @Autowired
     private ModelOneService modelOneService;

    @Autowired
     private ModelTwoService modelTwoService;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public YearlyAllConsultAntibiotics getConsultationPrescForOneYear(){

        final List<ModelOne> consultationForOneYear = modelOneService.getConsultationForOneYear();
        final int consulAnt = consultationForOneYear.stream().filter(e -> e.getAbAtConsult()
                .equalsIgnoreCase("na")).collect(Collectors.toList()).size();
        final int consulSize = consultationForOneYear.size();

        final YearlyAllConsultAntibiotics build = YearlyAllConsultAntibiotics.builder()
                .allConsultations(consulSize)
                .allConsultAntibiotics(consulAnt)
                .build();
        return  build;

    }
    public YearlyAllPresAntibiotics getPresYearlyAntibiotics(){
        final List<ModelTwo> prescriptionPerYear = modelTwoService.getPrescriptionPerYear();
        final int presAnt = prescriptionPerYear.stream()
                .filter(e -> e.getAbClassification().equalsIgnoreCase("NA")).collect(Collectors.toList()).size();

        final int presSize= prescriptionPerYear.size();

       return YearlyAllPresAntibiotics.builder()
                .allPrescripAntibiotics(presAnt)
                .allPrescriptions(presSize)
                .build();
    }
}
