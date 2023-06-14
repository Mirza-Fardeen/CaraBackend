package com.example.cara.org.CaraSecurity.repository;


import com.example.cara.org.CaraSecurity.domain.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepo extends JpaRepository<Consultation,Long> {
    Consultation findByConsultationId(String id);
}
