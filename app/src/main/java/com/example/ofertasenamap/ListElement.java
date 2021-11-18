package com.example.ofertasenamap;

public class ListElement {
    private int color;
    private String name;
    private String country;
    private String status;

    public ListElement(int color, String name, String country, String status) {
        this.color = color;
        this.name = name;
        this.country = country;
        this.status = status;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
