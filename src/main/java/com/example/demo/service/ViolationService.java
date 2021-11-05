package com.example.demo.service;

import com.example.demo.entity.Violation;
import com.example.demo.mapper.DriverMapper;
import com.example.demo.mapper.ViolationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationService {
    @Autowired
    private ViolationMapper violationMapper;
    @Autowired
    private DriverMapper driverMapper;
    //查询所有违章信息
    public List<Violation> findAllViolation(String license){return violationMapper.findAllViolation(license);}
    //查询单条违章信息
    public Violation findViolation(long num){return violationMapper.findViolation(num);}

    //根据前端返回bool值判断是否删除违章信息
    public void deleteViolation(long num,boolean request){
        if(request){
            violationMapper.deleteViolation(num);
        }else {
            this.changeRequest(num);
        }
    }
    //添加违章信息
    public void addViolation(String license,
                             String violation,
                             int fine,
                             int score)
    {
        violationMapper.addViolation(license,violation,fine,score,System.currentTimeMillis());
    }
    //查询车辆总扣分
    public int findScore(String license){
        int totalScores = 0;
        List<Violation> list=violationMapper.findAllViolation(license);
        for (Violation violation : list) {
            totalScores+=violation.getScore();
        }
        return totalScores;
    }

    //查询所有需要审批的违章信息
    public List<Violation> findAllRequestViolation() {
        return violationMapper.findAllRequestViolation();
    }

    //修改违章信息对应的bool值
    public void changeRequest(long num){
        violationMapper.changeRequest(num);
    }

    //提交申请消除违章信息通过后将违章信息能否删除bool值改为true
    public void setRequest(long num){
        violationMapper.setRequest(num);
    }
}
