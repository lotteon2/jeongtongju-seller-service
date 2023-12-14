package com.jeontongju.seller.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SellerProducer<T> {

  private final KafkaTemplate<String, T> kafkaTemplate;

  public void deleteSellerToProduct(T sellerId) {
    kafkaTemplate.send("delete-seller-to-product", sellerId);
  }

  public void deleteSellerToReview(T sellerId) {
    kafkaTemplate.send("delete-seller-to-review", sellerId);
  }

  public void sendUpdateSeller(T sellerInfoDto) {
    kafkaTemplate.send("update-seller", sellerInfoDto);
  }
}
