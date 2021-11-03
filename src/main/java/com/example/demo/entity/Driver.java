package com.example.demo.entity;

public class Driver {
    private int driver_id;
    private String name;
    private String car_license;
    private int totalscore;

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
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

    public int getTotalscore() { return totalscore; }

    public Driver(int totalscore) { this.totalscore = totalscore; }

    public Driver(int driver_id, String name, String car_license, int totalscore) {
        this.driver_id = driver_id;
        this.name = name;
        this.car_license = car_license;
        this.totalscore = totalscore;
    }
}
