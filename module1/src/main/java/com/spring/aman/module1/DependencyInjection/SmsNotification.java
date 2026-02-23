package com.spring.aman.module1.DependencyInjection;

import com.spring.aman.module1.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@Qualifier("SmSMessage")
//@ConditionalOnProperty(name="notification.type",havingValue ="sms")
public class SmsNotification implements NotificationService{

    @Override

    public void send(String message) {
        System.out.println("Sms message : "+message);
    }
}
