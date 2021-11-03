package com.example.demo.entity;

import java.sql.Timestamp;

public class Violation {
    private String carlicense;
    private String violation;
    private int fine;
    private Timestamp time;
    private int score;

    public String getCarlicense(){ return carlicense; }

    public Violation(String carlicense) {
        this.carlicense = carlicense;
    }

    public String getViolation() { return violation; }

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

    public void setScore(int score) { this.score = score; }

    public Violation(String carlicense,String violation,int fine,Timestamp time,int score){
        this.carlicense  = carlicense;
        this.violation = violation;
        this.fine = fine;
        this.time = time;
        this.score = score;
    }
}
