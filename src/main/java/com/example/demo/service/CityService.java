package com.example.demo.service;

import com.example.demo.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;
    public int getCityId(String name){
        return cityMapper.getId(name).getCity_id();
    }
}