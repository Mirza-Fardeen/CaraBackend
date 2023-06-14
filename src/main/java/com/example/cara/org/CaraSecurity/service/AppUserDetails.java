package com.example.cara.org.CaraSecurity.service;

import com.example.cara.org.CaraSecurity.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AppUserDetails implements UserDetails {

    private AppUser appUser;

    @Autowired
    public AppUserDetails(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        final List<SimpleGrantedAuthority> collect =
                Arrays.stream(appUser.getAuthorities()).map(e -> new SimpleGrantedAuthority(e)).collect(Collectors.toList());

        return collect;

    }

    @Override
    public String getPassword() {
        return appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return appUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
