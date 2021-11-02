package com.example.demo.service;

import com.example.demo.entity.Car;
import com.example.demo.mapper.CarMapper;
import com.example.demo.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Service
public class CarService {//处理业务逻辑

    @Autowired
    private CarMapper carMapper;
    @Autowired
    private CityService cityService;


    public List<Car> findAll(){
        List<Car> list=carMapper.findAll();
        this.SortList(list);
        return list;
    }
    public List<Car> findAllByCity(String name){
        List<Car> list=carMapper.findAllByCity(cityService.getCityId(name));
        this.SortList(list);
        return list;
    }

    public void changeViolation(int id,String vio){
        carMapper.changeViolation(id,vio);
    }

    public void changeModel(String driver_name,String model){
        carMapper.changeModel(driver_name,model);
    }
    public Car findCar(int engineId) {
        return carMapper.findCar(engineId);
    }
    public Car findCarBS(int engineId){
        List<Car> list=carMapper.findAll();
        this.SortList(list);
        return this.binarySearchCar(list,carMapper.findCar(engineId).getLicense());
    }
    public Car findCarByName(String name) {
        return carMapper.findCarByName(name);
    }
    public void deleteCar(int engine_id){
        carMapper.deleteCar(engine_id);
    }

    public void addCar(int engine_id,
                       String license,
                       String driver_name,
                       String city_name,
                       String violation,
                       String model)
    {
        carMapper.addCar(engine_id, license, driver_name, cityService.getCityId(city_name), violation, model);
    }

    public Car binarySearchCar(List<Car> list,String str){
        int left = 0;
        int right = list.size() - 1;
        int mid ;
        while (left <= right){
            mid = (left + right)/2;
            if(str.equals(list.get(mid).getLicense()))
                return list.get(mid);
            if(str.compareTo(list.get(mid).getLicense()) < 0)
                right = mid - 1;
            if(str.compareTo(list.get(mid).getLicense()) > 0)
                left = mid + 1;
        }
        return null;
    }
    public void SortList(List<Car> list){
        Collator co = Collator.getInstance(Locale.CHINA);
        list.sort(co);
//        for (Car car: list) {
//            System.out.println(car.getLicense());
//        }
    }
}
