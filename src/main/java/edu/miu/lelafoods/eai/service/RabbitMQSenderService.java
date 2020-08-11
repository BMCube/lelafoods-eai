package edu.miu.lelafoods.eai.service;

public interface RabbitMQSenderService {
	public void sendCartToRestaurant(String cart);
	public void  sendCartEmail(String cart);
//	public void initializeRabbit();
}