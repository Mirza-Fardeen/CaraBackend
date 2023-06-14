package com.example.cara.org.CaraSecurity.service;


import com.example.cara.org.CaraSecurity.domain.AppUser;
import com.example.cara.org.CaraSecurity.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private AppUserRepo appUserRepo;

    @Autowired
    public AppUserDetailsService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final AppUser byUsername = appUserRepo.findByUsername(username);
        if(byUsername!=null){
            final AppUserDetails appUserDetails = new AppUserDetails(byUsername);
            return  appUserDetails;
        }
        return null;
    }
}
