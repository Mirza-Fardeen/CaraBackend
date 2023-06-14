package com.example.cara.org.CaraSecurity.service;


import com.example.cara.org.CaraSecurity.domain.Consultation;
import com.example.cara.org.CaraSecurity.repository.ConsultationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepo consultationRepo;

    public Consultation saveConsultation(Consultation consultation){
        final Consultation build = Consultation.builder()
                .consultationId(consultation.getConsultationId())
                .patientId(consultation.getPatientId())
                .consultationType(consultation.getConsultationType())
                .userId(consultation.getUserId())
                .consultationDate(consultation.getConsultationDate())
                .dateCreated(consultation.getDateCreated())
                .dateModified(consultation.getDateModified())
                .build();
     return consultationRepo.save(build);
    }

    public int getAllConsultation(){
        final List<Consultation> all = consultationRepo.findAll();
       return all.size();
    }
}
