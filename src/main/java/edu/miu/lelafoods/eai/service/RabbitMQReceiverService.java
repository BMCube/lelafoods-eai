package edu.miu.lelafoods.eai.service;

import edu.miu.lelafoods.eai.domain.Order;

public interface RabbitMQReceiverService {
	public void receiverOrder(Order order);
}