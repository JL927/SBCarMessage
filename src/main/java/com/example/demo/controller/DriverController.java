package com.example.demo.controller;

import com.example.demo.entity.Driver;
import com.example.demo.service.DriverService;
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

    @RequestMapping("/findDriver/{name}/{car_license}")
    public Driver findDriver(@PathVariable String name, @PathVariable String car_license){
        return driverService.findDriver(name,car_license);
    }
}
