package edu.miu.lelafoods.eai.service;

import edu.miu.lelafoods.eai.dto.CartDto;

public interface RabbitMQSenderService {
	public void sendCartToRestaurant(CartDto cartDto);
	public void  sendCartEmail(CartDto cartDto);
}