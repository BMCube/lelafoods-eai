package edu.miu.lelafoods.order.service;

import edu.miu.lelafoods.order.domain.Order;

public interface RabbitMQReceiverService {
	public void receiverOrder(Order order);
}