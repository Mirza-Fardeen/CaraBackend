package com.example.cara.org.CaraSecurity.repository;


import com.example.cara.org.CaraSecurity.domain.ModelTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelTwoRepo extends JpaRepository<ModelTwo,Long> {
    List<ModelTwo> findByUserId(String userId);
}
