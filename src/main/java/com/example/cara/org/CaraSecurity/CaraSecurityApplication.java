package com.example.cara.org.CaraSecurity;

import com.example.cara.org.CaraSecurity.service.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;


@SpringBootApplication
public class CaraSecurityApplication implements CommandLineRunner {
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
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter( urlBasedCorsConfigurationSource);
	}


	@Override
	public void run(String... args) throws Exception {


		System.out.println(combineService.getConsultationPrescForOneYear());
		final Scanner scanner = new Scanner(new File("D:/Cara/Mike's_Practice/model_2.csv"));

		final FileReader fileReader = new FileReader("D:/Cara/Mike's_Practice/model_2.csv");

		String[] head =  {"patientid", "prescriptionid",	"issuedateconverted", 	"printdateconverted",
				"issueid",	"drugid", 	"uploadid",	"duration",	"atc1",	"prescriptiontype",	"scripttype",
				"icdindication",	"consultationid","userid",	"prescriptiondateconverted","dob",	"active",
				"patienttype"	,"gmsstatus",	"gender",	"ab_classification",	"atc_code",	"level_4",	"age"};

		final CSVFormat build = CSVFormat.DEFAULT.builder()
				.setHeader(head)
				.setSkipHeaderRecord(true)
				.build();

		final CSVParser parse = build.parse(fileReader);

		final Iterator<CSVRecord> iterator = parse.stream().iterator();

		BufferedReader bufferedReader = new BufferedReader(fileReader);


		int i =0;
		while(i<2){
			//651924
			if(i==0){
				bufferedReader.readLine();
			}
			else{
//
//				final String[] split = scanner.nextLine().split(",");
//				ModelTwo buil = ModelTwo.builder()
//						.patientId(getStringValue(split[0]))
//						.prescriptionId(getStringValue(split[1]))
//						.issueDate(getStringValue(split[2]))
//						.printDate(getStringValue(split[3]))
//						.issueId(getStringValue(split[4]))
//						.drugId(Long.valueOf(split[5]))
//						.uploadId(Long.valueOf(split[6]))
//						.duration(getIntValue(split[7]))
//						.atcOne(getStringValue(split[8]))
//						.prescriptionType(getIntValue(split[9]))
//						.scriptType(getIntValue(split[10]))
//						.icdIndication(getStringValue(split[11]))
//						.consultationId(getStringValue(split[12]))
//						.userId(getStringValue(split[13]))
//						.prescriptionDate(getStringValue(split[14]))
//						.dob(getStringValue(split[15]))
//						.active(Boolean.parseBoolean(split[16]))
//						.patientType(getIntValue(split[17]))
//						.gmsStatus(getIntValue(split[18]))
//						.gender(getStringValue(split[19]))
//						.abClassification(getStringValue(split[20]))
//						.atcCode(getStringValue(split[21]))
////						.levelFour(getStringValue(iterator.next().get("level_4")))
////						.age(getIntValue(iterator.next().get("age")))
//						.build();
//
//				 StringBuilder stringBuilder = new StringBuilder("");
//				for(int j=22; j<split.length-1; j++){
//					stringBuilder.append(split[j]);
//				}
//				buil.setLevelFour(stringBuilder.toString());
//				buil.setAge(getIntValue(split[split.length-1]));
//
//				modelTwoService.addModelTwo(buil);
//				System.out.println(buil.getAge()+ " i "+i);
//				stringBuilder.delete(0,stringBuilder.length());
				bufferedReader.readLine();
				System.out.println(i);
			}



			i++;
		}
	}

	public String getStringValue(String value){
		try {
			if(value.isEmpty() || value.isBlank() || value==null){

				value= "Empty";
			}
			else if(value==null){
				value= "Empty";
			}
		}
		catch (Exception e){
			value = "Empty";
		}

		return value;
	}
	public int getIntValue(String value){

		try {
			Integer.valueOf(value);
		}
		catch (NumberFormatException e){
			value= String.valueOf(0);
		}
		return Integer.parseInt(value);
	}

	public String getDateValue(String vale){
		try {
//			final PatientImmunisations build1 = PatientImmunisations.builder()
//						.immunisationId(getStringValue(iterator.next().get(split[0])))
//						.consultationId(getStringValue(iterator.next().get(split[1])))
//						.icpcCode(getStringValue(iterator.next().get(split[2])))
//						.dateAdministered(new Date(getDateValue(iterator.next().get(split[3]))))
//						.doseId(Integer.parseInt(getIntValue(iterator.next().get(split[4]))))
//						.drugId(Integer.parseInt(getIntValue(iterator.next().get(split[5]))))
//						.dateCreated(new Date(getDateValue(iterator.next().get(split[6]))))
//						.dateModified(new Date(getDateValue(iterator.next().get(split[7]))))
//						.patientId(getStringValue(iterator.next().get(split[8])))
//						.manufacturer(getStringValue(iterator.next().get(split[9])))
//						.agent(getStringValue(iterator.next().get(split[10])))
//						.tradeName(getStringValue(iterator.next().get(split[11])))
//						.build();
			final Date date = new Date(vale);
		}
		catch (Exception e){
			vale = String.valueOf(new Date());
		}
		return vale;
	}
}
