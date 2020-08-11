package edu.miu.lelafoods.eai.domain;

import java.util.List;

public class Cart {

    List<Order> orderList;

    public List<Order> getOrder() {
        return orderList;
    }

    public void setOrder(List<Order> order) {
        this.orderList = order;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "orderList=" + orderList +
                '}';
    }
}
