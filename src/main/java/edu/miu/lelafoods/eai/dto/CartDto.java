package edu.miu.lelafoods.eai.dto;

import java.util.List;

public class CartDto {

    List<Order> order;

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "orderList=" + order +
                '}';
    }
}
