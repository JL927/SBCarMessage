package com.example.demo.mapper;

import com.example.demo.entity.Car;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
@Repository
public interface CarMapper {//与数据库匹配

    List<Car> findAll();

    List<Car> findAllByCity(int cityid);

    Car findCar(int engine_id);
    Car findCarByName(String license);

    void changeViolation(int engine_id,String violation);

    void deleteCar(int engine_id);

    void addCar(int engine_id,
                String license,
                String driver_name,
                int cityid,
                String model);
    void changeModel(String driver_name,String model);
}
