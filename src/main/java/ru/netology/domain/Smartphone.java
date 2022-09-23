package ru.netology.domain;


public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int price, String maker) {
        super(id, name, price);
        this.manufacturer = maker;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}