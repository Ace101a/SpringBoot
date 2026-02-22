package com.spring.aman.module1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration

public class Config_class {

@Bean
    PaymentServices paymentServices(){
        return new PaymentServices();// how bean is create is defined by the user that is me

}
}
