package com.example.cara.org.CaraSecurity.controller;

import com.example.cara.org.CaraSecurity.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @GetMapping("/getConsultCount")
    public ResponseEntity<Integer> getAllConsultation(){
        return  ResponseEntity.status(200).body(consultationService.getAllConsultation());
    }
}
