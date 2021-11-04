package com.example.demo.controller;

import com.example.demo.entity.Car;
import com.example.demo.entity.Driver;
import com.example.demo.service.CarService;
import com.example.demo.service.DriverService;
import com.example.demo.service.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DriverController {
    @Autowired
    private DriverService driverService;
    @Autowired
    private CarService carService;
    @Autowired
    private ViolationService violationService;


    @RequestMapping("/findDriver/{name}/{car_license}")
    public Driver findDriver(@PathVariable String name, @PathVariable String car_license){
        return driverService.findDriver(name,car_license);
    }
    
    @RequestMapping("/addDriver/{driver_id}/{name}/{engineid}/{phone}")
    public boolean addDriver(@PathVariable long driver_id,
                             @PathVariable String name,
                             @PathVariable int engineid,
                             @PathVariable String phone){
        String lis=carService.findCar(engineid).getLicense();
        if(driverService.isIncluded(name,lis))
            return false;
        else{
            driverService.addDriver(driver_id,name,lis,phone);
            return true;
        }
    }

    @RequestMapping("/queryDriver/{name}")
    public Car queryDriver(@PathVariable String name){
       return carService.findCarByName(name);
    }

    @RequestMapping("/findScore/{license}")
    public int findScore(@PathVariable String license){ return violationService.findScore(license); }
    @RequestMapping("/changePhone/{name}/{phone}")
    public void changePhone(@PathVariable String name,@PathVariable String phone){ driverService.changePhone(name,phone); }
}
