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

    //查询所有车辆信息
    public List<Car> findAll(){
        List<Car> list=carMapper.findAll();
        //this.SortList(list);
        return list;
    }
    //查询所有车辆信息对应城市
    public List<Car> findAllByCity(String name){
        List<Car> list=carMapper.findAllByCity(cityService.getCityId(name));
        //this.SortList(list);
        return list;
    }

    //修改车辆违章记录
    public void changeViolation(int id,String vio){
        carMapper.changeViolation(id,vio);
    }
    //改变车辆型号
    public void changeModel(String license,String model){
        carMapper.changeModel(license,model);
    }
    //改变车辆颜色
    public void changeColor(String license,String color){
        carMapper.changeColor(license,color);
    }
    //根据发动机号查询车辆
    public Car findCar(int engineId) {
        return carMapper.findCar(engineId);
    }
    //通过二分搜索车牌号查询车辆信息
    public Car findCarBS(int engineId){
        List<Car> list=carMapper.findAll();
        this.SortList(list);
        return this.binarySearchCar(list,carMapper.findCar(engineId).getLicense());
    }
    //通过车牌号查询车主
    public Car findCarByName(String license) {
        return carMapper.findCarByName(license);
    }
    //删除车辆信息
    public void deleteCar(int engine_id){
        carMapper.deleteCar(engine_id);
    }
    //添加车辆信息
    public void addCar(int engine_id,
                       String license,
                       String driver_name,
                       String city_name,
                       String model,
                       String color)
    {
        carMapper.addCar(engine_id, license, driver_name, cityService.getCityId(city_name),model,color);
    }

    //二分搜索算法
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
    //根据车牌号对车辆进行升序排序
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
