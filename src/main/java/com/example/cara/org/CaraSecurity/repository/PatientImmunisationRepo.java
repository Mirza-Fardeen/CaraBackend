package com.example.cara.org.CaraSecurity.repository;

import com.example.cara.org.CaraSecurity.domain.PatientImmunisations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientImmunisationRepo extends JpaRepository<PatientImmunisations, Long> {
}
