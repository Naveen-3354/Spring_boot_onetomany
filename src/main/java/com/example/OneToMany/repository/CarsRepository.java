package com.example.OneToMany.repository;

import com.example.OneToMany.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Integer> {
}
