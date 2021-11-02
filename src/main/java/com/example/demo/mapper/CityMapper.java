package com.example.demo.mapper;

import com.example.demo.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CityMapper {
    int getId(String city_name);
}
