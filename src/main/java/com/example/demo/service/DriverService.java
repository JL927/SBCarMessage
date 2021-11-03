package com.example.demo.service;

import com.example.demo.entity.Driver;
import com.example.demo.mapper.CarMapper;
import com.example.demo.mapper.DriverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service(value = "driverService1")
public class DriverService {

    @Autowired
    private DriverMapper driverMapper;



    public Driver findDriver(String name,String car_license){
        return driverMapper.findDriver(name,car_license);
    }

    public void addDriver(int driver_id,String name,String lis,String phone){
        driverMapper.addDriver(driver_id,name,lis,phone);
    }

    public Boolean isIncluded(String name,String car_license){
        if(findDriver(name,car_license)!=null)
            return true;
        else return false;
    }


    public void updateScore(){

    };
}
