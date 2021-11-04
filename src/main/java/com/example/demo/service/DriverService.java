package com.example.demo.service;

import com.example.demo.entity.Driver;
import com.example.demo.mapper.CarMapper;
import com.example.demo.mapper.DriverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class DriverService {

    @Autowired
    private DriverMapper driverMapper;


    //查询司机信息
    public Driver findDriver(String name,String car_license){
        return driverMapper.findDriver(name,car_license);
    }

    //添加司机信息
    public void addDriver(long driver_id,String name,String lis,String phone){
        driverMapper.addDriver(driver_id,name,lis,phone);
    }

    //查询数据库是否曾经注册过人员信息
    public Boolean isIncluded(String name,String car_license){
        if(findDriver(name,car_license)!=null)
            return true;
        else return false;
    }

    //修改个人信息电话号码
    public void changePhone(String name,String phone){
        driverMapper.changePhone(name,phone);
    }
}
