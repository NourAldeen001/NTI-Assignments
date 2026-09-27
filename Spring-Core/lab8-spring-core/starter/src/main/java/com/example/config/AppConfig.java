package com.example.config;

import com.example.service.WelcomeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.example")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("Employee-Management-App")
    String companyName;

    // TODO: Bean for one minimum
    @Bean
    public WelcomeService welcomeService() {
        return new WelcomeService();
    }
}
