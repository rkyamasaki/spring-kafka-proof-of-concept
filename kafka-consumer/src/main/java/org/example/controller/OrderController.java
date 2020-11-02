package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.producer.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping(value = "/api/orders")
    public void send(@RequestBody String order) {
        orderProducer.send(order);
    }

}

