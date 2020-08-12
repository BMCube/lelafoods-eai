package edu.miu.lelafoods.eai.domain;

public class Order {
    private Food food;
    public Food getFood() {
        return food;
    }
    private int orderAmount;

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Order{" +
                " food=" + food +
                '}';
    }
}
