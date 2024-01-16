package com.jeontongju.seller.kafka;

import io.github.bitbox.bitbox.util.KafkaTopicNameInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SellerProducer<T> {

  private final KafkaTemplate<String, T> kafkaTemplate;

  public void deleteSellerToProduct(T sellerId) {
    kafkaTemplate.send(KafkaTopicNameInfo.DELETE_SELLER_TO_PRODUCT, sellerId);
  }

  public void deleteSellerToReview(T sellerId) {
    kafkaTemplate.send(KafkaTopicNameInfo.DELETE_PRODUCT_TO_REVIEW, sellerId);
  }

  public void deleteSellerToAuthentication(T sellerId) {
    kafkaTemplate.send(KafkaTopicNameInfo.DELETE_SELLER_AUTHENTICATION, sellerId);
  }

  public void sendUpdateSeller(T sellerInfoDto) {
    kafkaTemplate.send(KafkaTopicNameInfo.UPDATE_SELLER_TO_PRODUCT, sellerInfoDto);
  }
}
