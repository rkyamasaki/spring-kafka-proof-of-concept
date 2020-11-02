package controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import producer.OrderProducer;

@RestController
@RequestMapping(value = "/orders")
@Slf4j
@AllArgsConstructor
public class OrderController {
    
    private final OrderProducer orderProducer;
    
    @RequestMapping(method = RequestMethod.POST)
    public void send(@RequestBody String order) {
        orderProducer.send(order);
    }
    
    
}
