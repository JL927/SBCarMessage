package com.example.demo.mapper;

import com.example.demo.entity.Car;
import com.example.demo.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CityMapper {
    City getId(String city_name);
}
