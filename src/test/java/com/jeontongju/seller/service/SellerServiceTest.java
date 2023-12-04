package com.jeontongju.seller.service;

import com.jeontongju.seller.domain.Seller;
import com.jeontongju.seller.dto.reqeust.ModifySellerInfo;
import com.jeontongju.seller.dto.reqeust.SellerJudgeRequestDto;
import com.jeontongju.seller.dto.response.SellerInfoForConsumerDto;
import com.jeontongju.seller.dto.response.SellerInfoDetailsDto;
import com.jeontongju.seller.dto.response.SellerMyInfoDto;
import com.jeontongju.seller.dto.temp.SellerInfoDto;
import com.jeontongju.seller.dto.temp.SignUpInfo;
import com.jeontongju.seller.enums.ApprovalState;
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
            .sellerId(10L)
            .email("cc11@naver.com")
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

  @Test
  @DisplayName("TEST - getMySellerInfo")
  void getMySellerInfo() {
    Seller seller = initSeller();
    SellerMyInfoDto sellerMyInfoDto = sellerService.getMySellerInfo(seller.getSellerId());

    Assertions.assertThat(sellerMyInfoDto.getEmail()).isSameAs(seller.getEmail());
  }

  @Test
  @DisplayName("TEST - modifySellerApprovalState")
  void modifySellerApprovalState() {
    Seller seller = initSeller();
    SellerJudgeRequestDto sellerJudgeRequestDto = new SellerJudgeRequestDto(seller.getSellerId(), ApprovalState.ALLOW);
    Assertions.assertThat(seller.getApprovalState()).isSameAs(ApprovalState.WAIT);
    sellerService.modifySellerApprovalState(sellerJudgeRequestDto);
    Seller savedSeller = sellerRepository.findById(seller.getSellerId()).get();
    Assertions.assertThat(savedSeller.getApprovalState()).isSameAs(ApprovalState.ALLOW);
  }

  @Test
  @DisplayName("TEST -  getSellerOneForConsumer")
  void getSellerOneForConsumer() {
    Seller seller = initSeller();
    SellerInfoForConsumerDto sellerInfoForConsumerDto = sellerService.getSellerOneForConsumer(seller.getSellerId());

    Assertions.assertThat(sellerInfoForConsumerDto.getSellerId()).isSameAs(seller.getSellerId());
  }
  
  @Test
  @DisplayName("TEST - getSellerOne")
  void getSellerOne() {
    Seller seller = initSeller();
    SellerInfoDetailsDto sellerInfoDetails = sellerService.getSellerOne(seller.getSellerId());

    Assertions.assertThat(sellerInfoDetails.getSellerId()).isSameAs(seller.getSellerId());
    Assertions.assertThat(sellerInfoDetails.getEmail()).isSameAs(seller.getEmail());
  }

  @Test
  @DisplayName("TEST - modifySeller")
  void modifySeller() {
    Seller seller = initSeller();
    ModifySellerInfo modifySellerInfo = ModifySellerInfo.builder()
            .storeName("짱 도가")
            .storeImageUrl("/example/hi")
            .storePhoneNumber("0233332222")
            .build();

    sellerService.modifySeller(seller.getSellerId(), modifySellerInfo);
    Seller savedSeller = sellerRepository.findById(seller.getSellerId()).get();

    Assertions.assertThat(savedSeller.getStoreName()).isSameAs(modifySellerInfo.getStoreName());
    Assertions.assertThat(savedSeller.getStoreImageUrl()).isSameAs(modifySellerInfo.getStoreImageUrl());
  }

  @Test
  @DisplayName("TEST - saveSeller")
  void saveSeller() {

    SignUpInfo signUpInfo = SignUpInfo.builder()
            .memberId(2L)
            .email("cc11@naver.com")
            .storeName("우리도가")
            .storeDescription("짱맛이요~!")
            .storeImageUrl("/example")
            .storePhoneNumber("0233332222")
            .businessmanName("최최소")
            .businessmanPhoneNumber("01033332222")
            .build();

    Seller seller = sellerService.saveSeller(signUpInfo);

    Assertions.assertThat(seller.getSellerId()).isSameAs(signUpInfo.getMemberId());
    Assertions.assertThat(seller.getEmail()).isSameAs(signUpInfo.getEmail());
    Assertions.assertThat(seller.getApprovalState()).isSameAs(ApprovalState.WAIT);
  }
}
