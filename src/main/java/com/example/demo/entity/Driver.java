package com.example.demo.entity;

public class Driver {
    private long driver_id;
    private String name;
    private String car_license;
    private int rest_score;
    private String phone;

    public long getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(long driver_id) {
        this.driver_id = driver_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar_license() {
        return car_license;
    }

    public void setCar_license(String car_license) {
        this.car_license = car_license;
    }

    public int getRest_score() {
        return rest_score;
    }

    public void setRest_score(int rest_score) {
        this.rest_score = rest_score;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Driver() {
    }

    public Driver(long driver_id, String name, String car_license, int rest_score, String phone) {
        this.driver_id = driver_id;
        this.name = name;
        this.car_license = car_license;
        this.rest_score = rest_score;
        this.phone = phone;
    }
}
