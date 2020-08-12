package edu.miu.lelafoods.eai.service;

import edu.miu.lelafoods.eai.domain.Cart;

public interface RabbitMQSenderService {
	public void sendCartToRestaurant(Cart cart);
	public void  sendCartEmail(String cart);
}