package com.spring.aman.module1.DependencyInjection;

import com.spring.aman.module1.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
//@Primary
@Component
@Qualifier("EmailMessage")
//@ConditionalOnProperty(name="notification.type",havingValue ="email")
public class EmailNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email message : "+message);
    }
}
