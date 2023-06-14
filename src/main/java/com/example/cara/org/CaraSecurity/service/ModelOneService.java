package com.example.cara.org.CaraSecurity.service;


import com.example.cara.org.CaraSecurity.domain.ModelOne;
import com.example.cara.org.CaraSecurity.repository.ModelOneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelOneService {

    @Autowired
    private ModelOneRepo modelOneRepo;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public void addModelOne(ModelOne modelOne){
        final ModelOne build = ModelOne.builder()
                .age(modelOne.getAge())
                .gender(modelOne.getGender())
                .patientType(modelOne.getPatientType())
                .gmsStatus(modelOne.getGmsStatus())
                .abAtConsult(modelOne.getAbAtConsult())
                .icpcCodeFinal(modelOne.getIcpcCodeFinal())
                .icdCode(modelOne.getIcdCode())
                .icpcCode(modelOne.getIcpcCode())
                .consultationDate(modelOne.getConsultationDate())
                .consultationId(modelOne.getConsultationId())
                .patientId(modelOne.getPatientId())
                .levelFourFirst(modelOne.getLevelFourFirst())
                .build();

        modelOneRepo.save(build);
    }

    public List<ModelOne> getConsultationForOneYear(){
        Calendar instance = Calendar.getInstance();
        Date dateMaxCons = modelOneRepo.findAll().stream().filter(e -> e.getConsultationDate().length() > 10)
                .map(e -> e.getConsultationDate().substring(0, 10))
                .map(e -> {
                    try {
                        return simpleDateFormat.parse(e);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    return null;
                }).max(Date::compareTo).get();
        instance.setTime(dateMaxCons);

        final int i = instance.get(Calendar.YEAR) -1;


        final List<ModelOne> collectCons = modelOneRepo.findAll().stream().filter(e -> e.getConsultationDate().length() > 10)
                .filter(e -> {
                    try {
                        Calendar instance2 = Calendar.getInstance();
                        instance2.setTime(simpleDateFormat.parse(e.getConsultationDate().substring(0, 10)));
                        return instance2.get(Calendar.YEAR) > i;
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList());
        return  collectCons;
    }

//    public int getConsultationForOneYear() throws ParseException {
//        final Calendar instance = Calendar.getInstance();
//        final List<ModelOne> lis = modelOneRepo.findAll();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        final Date date = lis.stream().filter(e -> e.getConsultationDate().length() > 10)
//                .map(e -> e.getConsultationDate().substring(0, 10))
//                .map(e -> {
//                    try {
//                        return simpleDateFormat.parse(e);
//                    } catch (ParseException ex) {
//                        ex.printStackTrace();
//                    }
//                    return null;
//                }).max(Date::compareTo).get();
//        instance.setTime(date);
//        System.out.println(instance.get(Calendar.YEAR));
////        final Date date = collect.stream().max(Date::compareTo).get();
////
////        System.out.println(date);
////        final String consultationDate = lis.get(1).getConsultationDate();
////        System.out.println(simpleDateFormat.parse(consultationDate.substring(0,10)));
//
////        final List<ModelOne> na = lis.stream()
////                .filter(e -> !e.getAbAtConsult().equals("na")).collect(Collectors.toList());
////
////        System.out.println(lis.size() +" antibiotic "+na.size()+ "  color "+ na.get(1).getAbAtConsult());
//        return lis.size();
//    }
}


