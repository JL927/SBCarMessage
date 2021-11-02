package com.example.demo.controller;

import com.example.demo.entity.Car;
import com.example.demo.service.CarService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CarController {//与前端交互

    @Autowired
    private CarService carService;

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

    @RequestMapping("/addCar/{engine_id}/{license}/{driver_name}/{city_name}/{violation}/{model}")
    public void addCar(@PathVariable int engine_id,
                       @PathVariable String license,
                       @PathVariable String driver_name,
                       @PathVariable String city_name,
                       @PathVariable String violation,
                       @PathVariable String model)
    {
        carService.addCar(engine_id, license, driver_name, city_name, violation, model);
    }

    @RequestMapping("/changeViolation/{engineId}/{violation}")
    public void changeViolation(@PathVariable int engineId,@PathVariable String violation){
        carService.changeViolation(engineId,violation);
    }
}
