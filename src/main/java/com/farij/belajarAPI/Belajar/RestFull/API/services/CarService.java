package com.farij.belajarAPI.Belajar.RestFull.API.services;

import com.farij.belajarAPI.Belajar.RestFull.API.entities.CarEntitiy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarService {

    CarEntitiy addCar(CarEntitiy param);

    List<CarEntitiy> getallCar();

    CarEntitiy getCarById(int id);

    CarEntitiy updateCar(CarEntitiy param);

    void deleteCar(int id);
}
