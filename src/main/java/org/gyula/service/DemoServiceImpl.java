package org.gyula.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String getHelloMessage(String user, int age) {
        return "Hello, " + user + " I know, that you are " + age + " years old";
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this demo application.";
    }
}
