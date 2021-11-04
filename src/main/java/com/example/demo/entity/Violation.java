package com.example.demo.entity;

import java.sql.Timestamp;

public class Violation {
    private String license;
    private String violation;
    private int fine;
    private Timestamp time;
    private int score;
    private long num;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getViolation() {
        return violation;
    }

    public void setViolation(String violation) {
        this.violation = violation;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public Violation() {
    }

    public Violation(String license, String violation, int fine, Timestamp time, int score, long num) {
        this.license = license;
        this.violation = violation;
        this.fine = fine;
        this.time = time;
        this.score = score;
        this.num = num;
    }
}
