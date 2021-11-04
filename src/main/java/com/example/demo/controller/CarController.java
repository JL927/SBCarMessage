package com.example.demo.controller;

import com.example.demo.entity.Car;
import com.example.demo.entity.Violation;
import com.example.demo.service.CarService;
import com.example.demo.service.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin
public class CarController {//与前端交互

    @Autowired
    private CarService carService;
    @Autowired
    private ViolationService violationService;

    @PostMapping("/findAll")
    public List<Car> findAll(){
       return carService.findAll();
    }

    @RequestMapping("/findAllByCity/{name}")
    public List<Car> findAllByCity(@PathVariable String name){
        return carService.findAllByCity(name);
    }

    @RequestMapping("/findCar/{engineId}")
    public Car findCar(@PathVariable int engineId){
        return carService.findCar(engineId);
    }

    @RequestMapping("/findCarByName/{car_license}")
    public Car findCarByName(@PathVariable String car_license){
        return carService.findCarByName(car_license);
    }

    @RequestMapping("/deleteCar/{engine_id}")
    public void deleteCar(@PathVariable int engine_id){
        carService.deleteCar(engine_id);
    }

    @RequestMapping("/addCar/{engine_id}/{license}/{driver_name}/{city_name}/{model}/{color}")
    public void addCar(@PathVariable int engine_id,
                       @PathVariable String license,
                       @PathVariable String driver_name,
                       @PathVariable String city_name,
                       @PathVariable String model,
                       @PathVariable String color)
    {
        carService.addCar(engine_id, license, driver_name, city_name, model,color);
    }

    @RequestMapping("/changeViolation/{engineId}/{violation}")
    public void changeViolation(@PathVariable int engineId,@PathVariable String violation){
        carService.changeViolation(engineId,violation);
    }

    @RequestMapping("/changeModel/{license}/{model}")
    public void changeModel(@PathVariable String license,@PathVariable String model){
        carService.changeModel(license, model);
    }
    @RequestMapping("/changeColor/{license}/{color}")
    public void changeColor(@PathVariable String license,@PathVariable String color){
        carService.changeColor(license, color);
    }

    @RequestMapping("/addViolation/{license}/{violation}/{fine}/{score}")
    public void addViolation(@PathVariable String license,
                             @PathVariable String violation,
                             @PathVariable int fine,
                             @PathVariable int score)
    {
        violationService.addViolation(license,violation,fine,score);
    }
    @RequestMapping("/findAllViolation/{license}")
    public List<Violation> findAllViolation(@PathVariable String license){
        return violationService.findAllViolation(license);
    }

    @RequestMapping("/findAllRequestViolation")
    public List<Violation> findAllRequestViolation(){
        return violationService.findAllRequestViolation();
    }
    @RequestMapping("/findViolation/{num}")
    public Violation findViolation(@PathVariable long num){
        return violationService.findViolation(num);
    }

    @RequestMapping("/deleteViolation/{num}/{request}")
    public void deleteViolation(@PathVariable long num,@PathVariable boolean request){
        violationService.deleteViolation(num,request);
    }

    @RequestMapping("/setRequest/{num}")
    public void setRequest(@PathVariable long num){
        violationService.setRequest(num);
    }

}
