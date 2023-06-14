package com.example.cara.org.CaraSecurity.service;


import com.example.cara.org.CaraSecurity.domain.PrescriptionsIssue;
import com.example.cara.org.CaraSecurity.repository.PrescriptionIssueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionIssueService {
    @Autowired
    private PrescriptionIssueRepo prescriptionIssueRepo;

    public void savePIssue(PrescriptionsIssue prescriptionsIssue){
        final PrescriptionsIssue build = PrescriptionsIssue.builder()
                .issueId(prescriptionsIssue.getIssueId())
                .drugId(prescriptionsIssue.getDrugId())
                .prescriptionId(prescriptionsIssue.getPrescriptionId())
                .issueDate(prescriptionsIssue.getIssueDate())
                .printCount(prescriptionsIssue.getPrintCount())
                .duration(prescriptionsIssue.getDuration())
                .quantity(prescriptionsIssue.getQuantity())
                .userId(prescriptionsIssue.getUserId())
                .strength(prescriptionsIssue.getStrength())
                .form(prescriptionsIssue.getForm())
                .tradeName(prescriptionsIssue.getTradeName())
                .mainIngredient(prescriptionsIssue.getMainIngredient())
                .packSizeNum(prescriptionsIssue.getPackSizeNum())
                .printedDate(prescriptionsIssue.getPrintedDate())
                .dateCreated(prescriptionsIssue.getDateCreated())
                .dateModified(prescriptionsIssue.getDateModified())
                .atcOne(prescriptionsIssue.getAtcOne())
                .build();
        prescriptionIssueRepo.save(build);
    }

    public int findByIngredient(String ingredient){
        final List<PrescriptionsIssue> byMainIngredient = prescriptionIssueRepo.findByMainIngredient(ingredient);

        return  byMainIngredient.size();
    }
}
