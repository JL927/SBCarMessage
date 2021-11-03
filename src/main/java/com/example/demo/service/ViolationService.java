package com.example.demo.service;

import com.example.demo.entity.Violation;
import com.example.demo.mapper.ViolationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ViolationService {
    @Autowired
    private ViolationMapper violationMapper;
    public Violation findViolation(String carlicense){return violationMapper.findViolation(carlicense);}
    public void deleteViolation(String carlicense){violationMapper.deleteViolation(carlicense);}
    public void addViolation(String carlicense,
                             String violation,
                             int fine,
                             Timestamp time,
                             int score)
    {violationMapper.addViolation(carlicense,violation,fine,time,score);}
    public int findscore(String carlicense){
        int totalscores = 0;
        while (carlicense.equals(violationMapper.findViolation(carlicense).getCarlicense()))
        {
            totalscores +=violationMapper.findViolation(carlicense).getScore();
        }
        return totalscores;
    }
}
