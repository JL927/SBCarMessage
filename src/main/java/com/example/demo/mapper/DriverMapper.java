package com.example.demo.mapper;

import com.example.demo.entity.Driver;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DriverMapper {
     Driver findDriver(String name,String car_license);

     void addDriver(String name,String car_license);
}
