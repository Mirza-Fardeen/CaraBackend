package com.example.cara.org.CaraSecurity.repository;


import com.example.cara.org.CaraSecurity.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionsRepo extends JpaRepository<Prescription,Long> {
}
