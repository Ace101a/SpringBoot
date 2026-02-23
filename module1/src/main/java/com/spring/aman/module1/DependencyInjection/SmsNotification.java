package com.spring.aman.module1.DependencyInjection;

import com.spring.aman.module1.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class SmsNotification implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("Sms message : "+message);
    }
}
