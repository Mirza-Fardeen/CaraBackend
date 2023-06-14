package com.example.cara.org.CaraSecurity.controller;



import com.example.cara.org.CaraSecurity.response.YearlyAllConsultAntibiotics;
import com.example.cara.org.CaraSecurity.response.YearlyAllPresAntibiotics;
import com.example.cara.org.CaraSecurity.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MainController {

    @Autowired
    private AppService appService;

    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private PatientImmunisationService patientImmunisationService;

    @Autowired
    private PrescriptionsService prescriptionsService;

    @Autowired
    private PrescriptionIssueService prescriptionIssueService;

    @Autowired
    private ModelOneService modelOneService;

    @Autowired
    private ModelTwoService modelTwoService;

    @Autowired

    private CombineService combineService;

    @GetMapping("/consulAnt")
    public ResponseEntity<YearlyAllConsultAntibiotics> getYearlyConsultAnti(){
        return ResponseEntity.ok(combineService.getConsultationPrescForOneYear());
    }

    @GetMapping("/presAnt")
    public ResponseEntity<YearlyAllPresAntibiotics> getYearlyPresAnti(){
        return ResponseEntity.ok(combineService.getPresYearlyAntibiotics());
    }
}
