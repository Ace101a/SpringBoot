package com.spring.aman.module1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
//@Service // All are extended from Component
//@Repository
//@Controller
public class PaymentServices {
    public PaymentServices() {
        System.out.println("Constructor called");
    }
    public void pay(){
        System.out.println("Paying....");
    }
    @PostConstruct
    public void afterInitialization(){
        System.out.println("init done");
    }
    @PreDestroy
    public void beforeDestroy(){
        System.out.println("Destroyed");
    }
}
