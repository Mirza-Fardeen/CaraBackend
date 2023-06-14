package com.example.cara.org.CaraSecurity.controller;


import com.example.cara.org.CaraSecurity.service.PrescriptionIssueService;
import com.example.cara.org.CaraSecurity.service.PrescriptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class PrescriptionController {
    @Autowired
    private PrescriptionsService prescriptionsService;

    @Autowired
    private PrescriptionIssueService prescriptionIssueService;

    @GetMapping("/getPresCount")
    public ResponseEntity<Integer> getAllPrescription(){
        return ResponseEntity.status(200).body(prescriptionsService.getAllPrescriptions().size());
    }
    @GetMapping("/getPresService/{ing}")
    public ResponseEntity<Integer> getAllByName(@PathVariable(name = "ing") String ing){
        return  ResponseEntity.ok(prescriptionIssueService.findByIngredient(ing));
    }
}
