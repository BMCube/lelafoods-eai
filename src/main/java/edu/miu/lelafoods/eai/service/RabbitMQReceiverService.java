package edu.miu.lelafoods.eai.service;

import edu.miu.lelafoods.eai.dto.CartDto;

public interface RabbitMQReceiverService {
	public void receiverCart(CartDto cart);
}