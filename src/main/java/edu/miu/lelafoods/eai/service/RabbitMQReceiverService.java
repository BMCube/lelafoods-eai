package edu.miu.lelafoods.eai.service;

import edu.miu.lelafoods.eai.domain.Cart;

public interface RabbitMQReceiverService {
	public void receiverCart(Cart cart);
}