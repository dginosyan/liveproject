package domain.pastries;

import domain.item.Item;

import java.text.DecimalFormat;

public class PastryDto implements Item {
    private Long id;
    private String abbr;
    private String title;
    private double price;

    public PastryDto(Long id, String abbr, String title, double price) {
        this.id = id;
        this.abbr = abbr;
        this.title = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public String getFormattedPrice() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(price);
    }
}
