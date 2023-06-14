package com.example.cara.org.CaraSecurity.repository;


import com.example.cara.org.CaraSecurity.domain.PrescriptionsIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionIssueRepo extends JpaRepository<PrescriptionsIssue,Long> {
    List<PrescriptionsIssue> findByMainIngredient(String mainIngredient);
}
