package com.spring.aman.module1;

//cannot make @Component because interface cannot have object so we use where we have a class
public interface NotificationService {
    public void send(String message);

}
