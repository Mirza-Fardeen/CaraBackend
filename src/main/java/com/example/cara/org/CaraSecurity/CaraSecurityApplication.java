package com.example.cara.org.CaraSecurity;

import com.example.cara.org.CaraSecurity.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaraSecurityApplication {
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



	public static void main(String[] args) {
		SpringApplication.run(CaraSecurityApplication.class, args);
	}

}
