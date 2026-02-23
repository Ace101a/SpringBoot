package com.spring.aman.module1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1Application implements CommandLineRunner {


	@Autowired
//	PaymentServices payment;


	NotificationService NotificationServices;
	public Module1Application(NotificationService NotificationServices){
		this.NotificationServices=NotificationServices;
	}
	public static void main(String[] args) {

		SpringApplication.run(Module1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		payment.pay();
		NotificationServices.send("hello");
	}
}
