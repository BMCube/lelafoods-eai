package edu.miu.lelafoods.eai.domain;

import java.text.DecimalFormat;

public class Food {

    private String name;

    private Double price;

    private Double total;

    private static DecimalFormat df2 = new DecimalFormat("#.##");


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", total=" + df2.format(total) +
                '}';
    }
}
