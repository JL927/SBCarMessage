package com.example.demo.mapper;

import com.example.demo.entity.Car;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CarMapper {//与数据库匹配

    List<Car> findAll();

    List<Car> findAllByCity(int cityid);

    Car findCar(int engine_id);
    Car findCarByName(String driver_name);

    void changeViolation(int engine_id,String violation);

}
