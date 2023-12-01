package com.jeontongju.seller.service;

import com.jeontongju.seller.domain.Seller;
import com.jeontongju.seller.dto.temp.SellerInfoDto;
import com.jeontongju.seller.repository.SellerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class SellerServiceTest {

  @Autowired private SellerService sellerService;
  @Autowired private SellerRepository sellerRepository;

  Seller initSeller() {
    Seller sellerEntity =
        Seller.builder()
            .sellerId(1L)
            .storeName("우리도가")
            .storeDescription("짱맛이요~!")
            .storeImageUrl("/example")
            .storePhoneNumber("0233332222")
            .businessmanName("최최소")
            .businessmanPhoneNumber("01033332222")
            .build();

    return sellerRepository.save(sellerEntity);
  }

  @Test
  @DisplayName("TEST - getSellerInfo - feign request")
  void getSellerInfo() {
    Seller seller = initSeller();
    SellerInfoDto sellerInfoDto = sellerService.getSellerInfo(seller.getSellerId());

    Assertions.assertThat(sellerInfoDto.getStoreName()).isSameAs(seller.getStoreName());
    Assertions.assertThat(sellerInfoDto.getStoreImageUrl()).isSameAs(seller.getStoreImageUrl());
  }
}
