package com.jeontongju.seller.repository;

import com.jeontongju.seller.domain.Seller;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class SellerRepositoryTest {

  @Autowired private SellerRepository sellerRepository;

  @Test
  @DisplayName("TEST - create seller")
  void createSeller() {

      Seller sellerEntity = Seller.builder()
              .sellerId(1L)
              .storeName("우리도가")
              .storeDescription("짱맛이요~!")
              .storeImageUrl("/example")
              .storePhoneNumber("0233332222")
              .businessmanName("최최소")
              .businessmanPhoneNumber("01033332222")
              .build();

      Seller seller = sellerRepository.save(sellerEntity);

      Assertions.assertThat(seller.getStoreName()).isSameAs(sellerEntity.getStoreName());
      Assertions.assertThat(seller.getApprovalState()).isSameAs(sellerEntity.getApprovalState());
  }
}
