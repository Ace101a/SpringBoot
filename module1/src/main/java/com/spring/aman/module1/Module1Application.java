package com.spring.aman.module1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1Application implements CommandLineRunner {


//	@Autowired
//	PaymentServices payment;
//	final NotificationService NotificationServices;

//	public Module1Application(NotificationService NotificationServices)
//	{
//		this.NotificationServices=NotificationServices;
//	}
//		public Module1Application(NotificationService NotificationServices)
//	{
//		this.NotificationServices=NotificationServices;
//	}
	@Autowired
	Map<String,NotificationService> NotificationServicesMap = new HashMap<>();

	public static void main(String[] args) {

		SpringApplication.run(Module1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		payment.pay();
//		NotificationServices.send("hello");
		for(var notif : NotificationServicesMap.entrySet()){
			System.out.println(notif.getKey());
			notif.getValue().send("Hello");
		}
	}
}
