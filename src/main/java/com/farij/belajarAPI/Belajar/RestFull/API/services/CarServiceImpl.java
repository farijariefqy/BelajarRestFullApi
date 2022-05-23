package com.farij.belajarAPI.Belajar.RestFull.API.services;

import com.farij.belajarAPI.Belajar.RestFull.API.entities.CarEntitiy;
import com.farij.belajarAPI.Belajar.RestFull.API.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public CarEntitiy addCar(CarEntitiy param) {

        return carRepository.save(param);
    }

    @Override
    public List<CarEntitiy> getallCar() {
        return carRepository.findAll();
    }

    @Override
    public CarEntitiy getCarById(int id) {
        return carRepository.findById(id).get();
    }

    @Override
    public CarEntitiy updateCar(CarEntitiy param) {
        CarEntitiy findCar = carRepository.findById(param.getId()).get();
        findCar.setCarName(param.getCarName());
        findCar.setCarName(param.getColor());
        findCar.setCarName(param.getNumber());
        findCar.setCarName(param.getType());

        return carRepository.save(param);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }


}
