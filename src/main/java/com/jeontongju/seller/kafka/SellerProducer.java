package com.jeontongju.seller.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SellerProducer<T> {

    private final KafkaTemplate<String, T> kafkaTemplate;

    public void deleteSeller(T sellerId) {
        kafkaTemplate.send("delete-seller", sellerId);
    }
}
