package org.gyula.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    // publlic methods
    @Override
    public String getHelloMessage(String user) {
        return "Hello, " + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this demo application.";
    }
}
