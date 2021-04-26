package com.manning.liveproject.dg.liveproject.controllers.catalog;

public class Pastry {
    private String abbr;
    private String title;
    private Double price;

    public Pastry(String abbr, String title, Double price) {
        this.abbr = abbr;
        this.title = title;
        this.price = price;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }
}
