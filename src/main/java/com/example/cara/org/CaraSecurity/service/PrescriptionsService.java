package com.example.cara.org.CaraSecurity.service;


import com.example.cara.org.CaraSecurity.domain.Prescription;
import com.example.cara.org.CaraSecurity.repository.PrescriptionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionsService {

    @Autowired
    private PrescriptionsRepo prescriptionsRepo;

    public void savePrescription(Prescription prescription){
        final Prescription build = Prescription.builder()
                .prescriptionId(prescription.getPrescriptionId())
                .consultationId(prescription.getConsultationId())
                .prescriptionDate(prescription.getPrescriptionDate())
                .dateCreated(prescription.getDateCreated())
                .dateModified(prescription.getDateModified())
                .prescriptionType(prescription.getPrescriptionType())
                .scriptType(prescription.getScriptType())
                .userId(prescription.getUserId())
                .patientId(prescription.getPatientId())
                .build();
        prescriptionsRepo.save(build);
    }
    public List<Prescription> getAllPrescriptions(){
       return prescriptionsRepo.findAll();
    }
}
