package com.jeontongju.seller.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductProducer<T> {

  private final KafkaTemplate<String, T> kafkaTemplate;

  public void sendUpdateSeller(T sellerInfoDto) {
    kafkaTemplate.send("update-seller", sellerInfoDto);
  }
}
