package com.neostore.api.service;

import jakarta.enterprise.context.ApplicationScoped;

/**
 *
 * @author kaciano
 */
@ApplicationScoped
public class HelloWorldService {
    
    public String getHelloWorld(String name) {
        return "Hello " + name;
    }
}
