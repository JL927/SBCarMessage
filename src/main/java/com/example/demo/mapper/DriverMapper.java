package com.example.demo.mapper;

import com.example.demo.entity.Driver;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DriverMapper {
     Driver findDriver(String name,String car_license);

     void addDriver(long driver_id,String name,String car_license,String phone);

     void changePhone(String name,String phone);
     void updateScore(String car_license,int rest_score);
}
