package org.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // Change to new Class<?>[] { YourRootConfig.class } if you have a separate DB/security config
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { AppConfig.class }; // Registers your Spring configuration
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // Map DispatcherServlet to handle all incoming requests
    }
}
