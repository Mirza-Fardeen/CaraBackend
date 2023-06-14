package com.example.cara.org.CaraSecurity.repository;


import com.example.cara.org.CaraSecurity.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
