package com.example.demo.service;

import com.example.demo.entity.Violation;
import com.example.demo.mapper.ViolationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ViolationService {
    @Autowired
    private ViolationMapper violationMapper;
    public List<Violation> findAllViolation(String license){return violationMapper.findAllViolation(license);}
    public Violation findViolation(long num){return violationMapper.findViolation(num);}

    public void deleteViolation(long num){violationMapper.deleteViolation(num);}
    public void addViolation(String license,
                             String violation,
                             int fine,
                             int score)
    {
        violationMapper.addViolation(license,violation,fine,score,System.currentTimeMillis());
    }
    public int findScore(String license){
        int totalScores = 0;
        List<Violation> list=violationMapper.findAllViolation(license);
        for (Violation violation : list) {
            totalScores+=violation.getScore();
        }
        return totalScores;
    }
}
