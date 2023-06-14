package com.example.cara.org.CaraSecurity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AppUserRequest {

    private String username ;

    private String email;

    private String password;


    private String profession;

}
