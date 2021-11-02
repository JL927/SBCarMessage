package com.example.demo.service;

import com.example.demo.entity.Car;
import com.example.demo.mapper.CarMapper;
import com.example.demo.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.*;

@Service
public class CarService {//处理业务逻辑

    @Autowired
    private CarMapper carMapper;
    @Autowired
    private CityService cityService;


    public List<Car> findAll(){
        List<Car> list=carMapper.findAll();
        //this.SortList(list);
        return list;
    }
    public List<Car> findAllByCity(String name){
        List<Car> list=carMapper.findAllByCity(cityService.getCityId(name));
        //this.SortList(list);
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
    public Car findCarByName(String license) {
        return carMapper.findCarByName(license);
    }
    public void deleteCar(int engine_id){
        carMapper.deleteCar(engine_id);
    }

    public void addCar(int engine_id,
                       String license,
                       String driver_name,
                       String city_name,
                       String model)
    {
        carMapper.addCar(engine_id, license, driver_name, cityService.getCityId(city_name),model);
    }

    public Car binarySearchCar(List<Car> list,String str){
        Iterator<Car> it=list.iterator();
        String[] strs=new String[list.size()];
        int i=0;
        while(it.hasNext()){
            strs[i++]=it.next().getLicense();
        }
        int left = 0;
        int right = strs.length - 1;
        int mid ;
        while (left <= right){
            mid = (left + right)/2;
            if(str.equals(strs[mid]))
                return list.get(mid);
            if(str.compareTo(strs[mid]) < 0)
                right = mid - 1;
            if(str.compareTo(strs[mid]) > 0)
                left = mid + 1;
        }
        return null;
    }
    public void SortList(List<Car> list){
//        Collator co = Collator.getInstance(Locale.CHINA);
//        String[] strs = (String[]) list.toArray();
//        Arrays.sort(strs, co);
        list.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                String s1=o1.getLicense();
                String s2=o2.getLicense();
                if(s1.substring(0,1).compareTo(s2.substring(0,1))==0){
                    return s1.substring(1).compareTo(s2.substring(1));
                }else
                    return s1.substring(0,1).compareTo(s2.substring(0,1));
            }
        });
//        for (Car car: list) {
//            System.out.println(car.getLicense());
//        }
    }
}
