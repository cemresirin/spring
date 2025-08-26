package com.cemre.demo.ioc;

import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
    public String printMessage() {
        return "Hello Ioc";
    }
}
