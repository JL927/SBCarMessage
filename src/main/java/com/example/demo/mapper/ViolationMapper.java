package com.example.demo.mapper;

import com.example.demo.entity.Violation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface ViolationMapper {
    List<Violation> findAllViolation(String license);
    Violation findViolation(long num);
    void deleteViolation(long num);
    void addViolation(String license,
                      String violation,
                      int fine,
                      int score,
                      long num);
    void changeRequest(long num);
    void setRequest(long num);

    List<Violation> findAllRequestViolation();
}
