package com.farij.belajarAPI.Belajar.RestFull.API.repositories;

import com.farij.belajarAPI.Belajar.RestFull.API.entities.CarEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntitiy, Integer>{

}
