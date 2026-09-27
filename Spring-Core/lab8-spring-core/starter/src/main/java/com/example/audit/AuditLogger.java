package com.example.audit;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(scopeName = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AuditLogger {

    @PostConstruct
    public void init() {
        System.out.println("logging init method: " + System.currentTimeMillis());
    }

    public void log() {
        System.out.println("Logging");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("logging destroy method: " + System.currentTimeMillis());
    }
}
