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

    @RequestMapping("/findAllByCity/{cityid}")
    public List<Car> findAllByCity(@PathVariable int cityid){
        return carService.findAllByCity(cityid);
    }

    @RequestMapping("/findCar/{engineId}")
    public Car findCar(@PathVariable int engineId){
        return carService.findCar(engineId);
    }

    @RequestMapping("/findCarByName/{car_license}")
    public Car findCarByName(@PathVariable String car_license){
        return carService.findCarByName(car_license);
    }


    @RequestMapping("/changeViolation/{engineId}/{violation}")
    public void changeViolation(@PathVariable int engineId,@PathVariable String violation){
        carService.changeViolation(engineId,violation);
    }
}
