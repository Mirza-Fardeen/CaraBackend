package com.example.cara.org.CaraSecurity.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class AppUser {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String email;

    private String password;

    private String profession;

    private Date joinDate;

    private String role;

    private String [] authorities;

}
