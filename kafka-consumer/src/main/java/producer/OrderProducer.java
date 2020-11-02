package producer;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Component
public class OrderProducer {
    
    @Value("${order.topic}")
    private String orderTopic;
    
    private final KafkaTemplate kafkaTemplate;
    
    public OrderProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public final void send(final @RequestBody String order) {
        final String messageKey = UUID.randomUUID().toString();
        kafkaTemplate.send(orderTopic, messageKey, order);
    }
    
}
