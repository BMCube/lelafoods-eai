package edu.miu.lelafoods.eai.dto;

public class Order {
    private Food food;
    private int orderQuantity;

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setFood(Food food) {
        this.food = food;
    }
    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "Order{" +
                "food=" + food +
                ", orderQuantity=" + orderQuantity +
                '}';
    }
}
