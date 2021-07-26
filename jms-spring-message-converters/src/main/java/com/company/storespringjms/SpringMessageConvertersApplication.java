package com.company.storespringjms;

import com.company.storespringjms.model.Book;
import com.company.storespringjms.model.BookOrder;
import com.company.storespringjms.model.Customer;
import com.company.storespringjms.service.SendBookOrderService;
import com.company.storespringjms.util.Sender;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@EnableJms
@SpringBootApplication
public class SpringMessageConvertersApplication implements CommandLineRunner {

	@Autowired
	private SendBookOrderService sendBookOrderService;

	public static void main(String[] args) {
		SpringApplication.run(com.company.storespringjms.SpringMessageConvertersApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(
				com.company.storespringjms.SpringMessageConvertersApplication.class, args
		);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book = new Book("1", "Horizons");
		Customer customer = new Customer("1", "I Ahmed");
		BookOrder bookOrder = new BookOrder("1", book, customer);
		sendBookOrderService.send(bookOrder);
	}
}
