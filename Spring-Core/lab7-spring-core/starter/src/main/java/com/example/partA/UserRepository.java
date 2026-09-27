package com.example.partA;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

public class UserRepository implements BeanNameAware, DisposableBean { // , DisposableBean

    public UserRepository() {
        System.out.println("1. [UserRepository] Constructor - Instantiated");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2. [UserRepository] - Aware Interfaces");
    }

    public void customInit() {
        System.out.println("3. [UserRepository] - custom init method -> from XML");
//        System.out.println("3. [UserRepository] - custom init method -> from XML " + System.currentTimeMillis());
    }

    public void findAll() {
        System.out.println("4. [UserRepository] - findAll() called means -> bean is ready and in use");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("5. [UserRepository] - destroy() -> DisposableBean ");
//        System.out.println("5. [UserRepository] - destroy() -> DisposableBean " + System.currentTimeMillis());
    }

    public void customDestroy() {
        System.out.println("6. [UserRepository] - custom destroy method -> from XML ");
//        System.out.println("6. [UserRepository] - custom destroy method -> from XML " + System.currentTimeMillis());
    }






}
