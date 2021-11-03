package com.example.demo.mapper;

import com.example.demo.entity.Violation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Mapper
@Repository
public interface ViolationMapper {
    Violation findViolation(String carlicense);
    void deleteViolation(String carlicense);
    void addViolation(String carlicense,
                      String violation,
                      int fine,
                      Timestamp time,
                      int score);
    int findscore(String carlicense);
}
