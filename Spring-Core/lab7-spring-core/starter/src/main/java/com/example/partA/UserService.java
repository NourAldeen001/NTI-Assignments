package com.example.partA;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class UserService implements BeanNameAware, DisposableBean , InitializingBean  { // , DisposableBean , InitializingBean

    private UserRepository userRepository;

    public UserService() {
        System.out.println("1. [UserService] Constructor - Instantiated");
    }

    public void setUserRepository(UserRepository userRepository) {
        System.out.println("2. [UserService] - setUserRepository() setting properties");
        this.userRepository = userRepository;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("3. [UserService] - Aware Interfaces | id: " + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        System.out.println("4. [UserService] - Bean Initialization "  + System.currentTimeMillis());
        System.out.println("4. [UserService] - Bean Initialization ");
        throw new RuntimeException("I Don't Know");
    }

    public void customInit() {
//        System.out.println("5. [UserService] - custom init method -> from XML " + System.currentTimeMillis());
        System.out.println("5. [UserService] - custom init method -> from XML ");

    }

    public void doWork() {
        System.out.println("6. [UserService] - doWork() called -> bean is ready and in use");
        userRepository.findAll();
    }

    @Override
    public void destroy() throws Exception {
//        System.out.println("7. [UserService] - destroy() called -> DisposableBean " + System.currentTimeMillis());
        System.out.println("7. [UserService] - destroy() called -> DisposableBean ");

    }

    public void customDestroy() {
//        System.out.println("8. [UserService] - custom destroy method -> from XML " + System.currentTimeMillis());
        System.out.println("8. [UserService] - custom destroy method -> from XML ");
    }
}
