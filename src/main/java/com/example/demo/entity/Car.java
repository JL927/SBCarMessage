package com.example.demo.entity;


public class Car {
    private int engine_id;
    private String license;
    private String violation;
    private int cityid;
    private String driver_name;
    private String model;

    public Car() {
    }

    public Car(int engine_id, String license, String violation, int cityid, String driver_name, String model) {
        this.engine_id = engine_id;
        this.license = license;
        this.violation = violation;
        this.cityid = cityid;
        this.driver_name = driver_name;
        this.model = model;
    }

    public int getEngine_id() {
        return engine_id;
    }

    public void setEngine_id(int engine_id) {
        this.engine_id = engine_id;
    }

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

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
