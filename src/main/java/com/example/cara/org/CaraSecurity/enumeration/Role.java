package com.example.cara.org.CaraSecurity.enumeration;

import static com.example.cara.org.CaraSecurity.constant.Authority.USER_AUTHORITIES;


public enum Role {
    ROLE_USER(USER_AUTHORITIES);

    private String [] authorites;

    Role(String [] userAuthorites){
        this.authorites = userAuthorites;
    }

    public String [] getAuthorities(){
        return this.authorites;
    }
}
