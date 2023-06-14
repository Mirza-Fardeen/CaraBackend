package com.example.cara.org.CaraSecurity.service;


import com.example.cara.org.CaraSecurity.domain.PatientImmunisations;
import com.example.cara.org.CaraSecurity.repository.PatientImmunisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientImmunisationService {

    @Autowired
    private PatientImmunisationRepo patientImmunisationRepo;


    public void addPI(PatientImmunisations patientImmunisations){
        final PatientImmunisations build = PatientImmunisations.builder()
                .immunisationId(patientImmunisations.getImmunisationId())
                .consultationId(patientImmunisations.getConsultationId())
                .icpcCode(patientImmunisations.getIcpcCode())
                .dateAdministered(patientImmunisations.getDateAdministered())
                .doseId(patientImmunisations.getDoseId())
                .drugId(patientImmunisations.getDrugId())
                .dateCreated(patientImmunisations.getDateCreated())
                .dateModified(patientImmunisations.getDateModified())
                .patientId(patientImmunisations.getPatientId())
                .manufacturer(patientImmunisations.getManufacturer())
                .agent(patientImmunisations.getAgent())
                .tradeName(patientImmunisations.getTradeName())
                .build();
        patientImmunisationRepo.save(build);
    }
}
