package com.example.cara.org.CaraSecurity.repository;


import com.example.cara.org.CaraSecurity.domain.ModelOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelOneRepo extends JpaRepository<ModelOne,Long> {
}
