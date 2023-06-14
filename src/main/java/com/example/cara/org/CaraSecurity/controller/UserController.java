package com.example.cara.org.CaraSecurity.controller;


import com.example.cara.org.CaraSecurity.domain.AppUser;
import com.example.cara.org.CaraSecurity.domain.AppUserRequest;
import com.example.cara.org.CaraSecurity.domain.Consultation;
import com.example.cara.org.CaraSecurity.repository.AppUserRepo;
import com.example.cara.org.CaraSecurity.service.AppService;
import com.example.cara.org.CaraSecurity.service.AppUserDetails;
import com.example.cara.org.CaraSecurity.service.ConsultationService;
import com.example.cara.org.CaraSecurity.utility.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTTokenProvider jwtTokenProvider;

    @Autowired
    private AppService appService;

    @Autowired
    private ConsultationService consultationService;

    @PostMapping("/test")
    public String getTest(@RequestBody AppUserRequest appUserRequest){
        final AppUser byUsername = appService.getUserByName(appUserRequest.getUsername());

        return "Test Successful " +byUsername.getProfession();
    }

    @GetMapping("jwt")
    public String getTokenTest(){
        return "token test working";
    }

    @PostMapping("/login")
    public ResponseEntity<String> getLogin(@RequestBody AppUserRequest appUserRequest){
        final AppUser byUsername = appUserRepo.findByUsername(appUserRequest.getUsername());
        authenticate(appUserRequest.getUsername(),appUserRequest.getPassword());

        final AppUserDetails appUserDetails = new AppUserDetails(byUsername);
        HttpHeaders httpHeaders = new HttpHeaders();
        final String s = jwtTokenProvider.generateToken(appUserDetails);
        httpHeaders.add("jwt-token",s);
        return  new ResponseEntity<>("working...",httpHeaders, HttpStatus.OK);
    }
    private void authenticate(String username ,String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

    }
    @PostMapping("/consultation")
    public void postConsultation(@RequestBody Consultation consultation){
        consultationService.saveConsultation(consultation);
    }
}
