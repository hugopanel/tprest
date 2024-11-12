package com.example.tprest.data;

public class Car {
    private String plateNumber;
    private String brand;
    private float price;

    public Car() {

    }

    public Car(String plateNumber, String brand, float price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
