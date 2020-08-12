package edu.miu.lelafoods.eai.domain;

import java.util.List;

public class Cart {

    List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "orderList=" + orderList +
                '}';
    }
}
