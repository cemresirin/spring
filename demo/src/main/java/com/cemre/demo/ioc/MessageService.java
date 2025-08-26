package com.cemre.demo.ioc;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessagePrinter printer;

    public MessageService(MessagePrinter printer) {
        this.printer = printer;
    }

    public String getMessage() {
        return printer.printMessage();
    }
}
