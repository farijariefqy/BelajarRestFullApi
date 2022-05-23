package com.farij.belajarAPI.Belajar.RestFull.API.controllers;

import com.farij.belajarAPI.Belajar.RestFull.API.entities.CarEntitiy;
import com.farij.belajarAPI.Belajar.RestFull.API.repositories.CarRepository;
import com.farij.belajarAPI.Belajar.RestFull.API.response.CommonResponse;
import com.farij.belajarAPI.Belajar.RestFull.API.response.CommonResponseGenerator;
import com.farij.belajarAPI.Belajar.RestFull.API.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CarController {



    @Autowired
    CarService carService;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @GetMapping(value = "CheckAPI")
    public CommonResponse<String> checkApi(){
        return commonResponseGenerator.successResponse("Hello World", "Sukses check api");
    }

    @PostMapping(value = "addNewCar")
    public CommonResponse<CarEntitiy> addNewCar(@RequestBody CarEntitiy param){

        try {
            CarEntitiy car = carService.addCar(param);
            return commonResponseGenerator.successResponse(car,"Success Add new data");
        }catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }

    }

    @GetMapping(value = "getAllCar")
    public CommonResponse<List<CarEntitiy>> getAllCar(){

        try {
            List<CarEntitiy> carList = carService.getallCar();
            return commonResponseGenerator.successResponse(carList,"Success Get All Data");
        }catch(Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }

    }

    @GetMapping(value = "getById")
    public CommonResponse<CarEntitiy> getById(@RequestParam int id){
        try{
            CarEntitiy car = carService.getCarById(id);

            return commonResponseGenerator.successResponse(car,"Success Get By Id");
        }catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }

    }

    @PostMapping(value = "updateCar")
    public CommonResponse<String> updateCar(@RequestBody CarEntitiy param){

        try {
            CarEntitiy car = carService.updateCar(param);
            return commonResponseGenerator.successResponse(car,"Success Update data id :" + param.getId());
        }catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage()+" for id: "+param.getId());
        }

    }

    @GetMapping(value = "deleteCar")
    public CommonResponse<List<CarEntitiy>> deleteCar(@RequestParam int id){
        try{
            carService.deleteCar(id);
            List<CarEntitiy> carList = carService.getallCar();
            return commonResponseGenerator.successResponse(carList, "Success Delete id ="+ id) ;
        }catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }

    }



}
