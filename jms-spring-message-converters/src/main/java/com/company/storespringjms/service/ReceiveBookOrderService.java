package com.company.storespringjms.service;

import com.company.storespringjms.model.BookOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReceiveBookOrderService {
//    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiveBookOrderService.class);
//
//    @JmsListener(destination = "book.order.queue")
//    public void receive(BookOrder bookOrder) {
//        LOGGER.info("Received a message");
//        LOGGER.info("Message is -> " + bookOrder);
//    }
}
