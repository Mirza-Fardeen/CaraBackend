package com.example.cara.org.CaraSecurity.service;


import com.example.cara.org.CaraSecurity.domain.ModelTwo;
import com.example.cara.org.CaraSecurity.repository.ModelTwoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelTwoService {
    @Autowired
    private ModelTwoRepo modelTwoRepo;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String[] head =  {"patientid", "prescriptionid",	"issuedateconverted", 	"printdateconverted",
            "issueid",	"drugid", 	"uploadid",	"duration",	"atc1",	"prescriptiontype",	"scripttype",
            "icdindication",	"consultationid","userid",	"prescriptiondateconverted","dob",	"active",
            "patienttype"	,"gmsstatus",	"gender",	"ab_classification",	"atc_code",	"level_4",	"age"};

    public void addModelTwo(ModelTwo modelTwo){
        final ModelTwo build = ModelTwo.builder()
                .patientId(modelTwo.getPatientId())
                .prescriptionId(modelTwo.getPrescriptionId())
                .issueDate(modelTwo.getIssueDate())
                .printDate(modelTwo.getPrintDate())
                .issueId(modelTwo.getIssueId())
                .drugId(modelTwo.getDrugId())
                .uploadId(modelTwo.getUploadId())
                .duration(modelTwo.getDuration())
                .atcOne(modelTwo.getAtcOne())
                .prescriptionType(modelTwo.getPrescriptionType())
                .scriptType(modelTwo.getScriptType())
                .icdIndication(modelTwo.getIcdIndication())
                .consultationId(modelTwo.getConsultationId())
                .userId(modelTwo.getUserId())
                .prescriptionDate(modelTwo.getPrescriptionDate())
                .dob(modelTwo.getDob())
                .active(modelTwo.isActive())
                .patientType(modelTwo.getPatientType())
                .gmsStatus(modelTwo.getGmsStatus())
                .gender(modelTwo.getGender())
                .abClassification(modelTwo.getAbClassification())
                .atcCode(modelTwo.getAtcCode())
                .levelFour(modelTwo.getLevelFour())
                .age(modelTwo.getAge())
                .build();

        modelTwoRepo.save(build);

    }

    public List<ModelTwo> getPrescriptionPerYear(){
        final Calendar instance1 = Calendar.getInstance();
        Date dateMaxPres = modelTwoRepo.findAll().stream().filter(e -> e.getPrescriptionDate().length() > 10)
                .map(e -> e.getPrescriptionDate().substring(0, 10))
                .map(e -> {
                    try {
                        return simpleDateFormat.parse(e);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    return null;
                }).max(Date::compareTo).get();
        instance1.setTime(dateMaxPres);

        final int i1 = instance1.get(Calendar.YEAR) - 1;

        final List<ModelTwo> collectPres= modelTwoRepo.findAll().stream().filter(e -> e.getPrescriptionDate().length() > 10)
                .filter(e -> {
                    try {
                        Calendar instance2 = Calendar.getInstance();
                        instance2.setTime(simpleDateFormat.parse(e.getPrescriptionDate().substring(0, 10)));
                        return instance2.get(Calendar.YEAR) > i1;
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList());
        return collectPres;
    }

//    public int antibioticInfo(String userId) throws Exception{
//        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//         int size = modelTwoRepo.findAll().stream().filter(e-> {
//             try {
//                 return simpleDateFormat.parse(e.getPrescriptionDate())
//                         .after(simpleDateFormat.parse("2017-01-01"));
//             } catch (ParseException ex) {
//                 ex.printStackTrace();
//             }
//             return false;
//         }).collect(Collectors.toList()).size();
//        return size;
//    }
//    public String getString(){
//        return  "blah";
//    }
}
