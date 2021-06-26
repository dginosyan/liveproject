package domain.pastries;

import java.text.DecimalFormat;

public class PastryDto {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFormattedPrice() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(price);
    }
}
