package com.example.demo.service;

import com.example.demo.entity.Car;
import com.example.demo.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService {//处理业务逻辑

    @Autowired
    private CarMapper carMapper;

    public List<Car> findAll(){
        return carMapper.findAll();
    }
    public List<Car> findAllByCity(int cityid){
        return carMapper.findAllByCity(cityid);
    }

    public void changeViolation(int id,String vio){
        carMapper.changeViolation(id,vio);
    }

    public Car findCar(int engineId) {
        return carMapper.findCar(engineId);
    }
    public Car findCarByName(String name) {
        return carMapper.findCarByName(name);
    }
}
