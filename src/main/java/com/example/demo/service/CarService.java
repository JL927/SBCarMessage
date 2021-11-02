package com.example.demo.service;

import com.example.demo.entity.Car;
import com.example.demo.mapper.CarMapper;
import com.example.demo.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService {//处理业务逻辑

    @Autowired
    private CarMapper carMapper;
    @Autowired
    private CityMapper cityMapper;

    public List<Car> findAll(){
        return carMapper.findAll();
    }
    public List<Car> findAllByCity(String name){
        return carMapper.findAllByCity(this.getCityId(name));
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

    public void deleteCar(int engine_id){
        carMapper.deleteCar(engine_id);
    }
    public int getCityId(String name){
        return cityMapper.getId(name);
    }

    public void addCar(int engine_id,
                       String license,
                       String driver_name,
                       String city_name,
                       String violation,
                       String model)
    {
        carMapper.addCar(engine_id, license, driver_name, this.getCityId(city_name), violation, model);
    }
}
