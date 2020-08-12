package edu.miu.lelafoods.eai.service;

import edu.miu.lelafoods.eai.domain.Order;

public interface RabbitMQSenderService {
	public void sendOrder(Order order);
	public void initializeRabbit();
}