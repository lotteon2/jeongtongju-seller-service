package com.jeontongju.seller.service;

import com.jeontongju.seller.domain.Seller;
import com.jeontongju.seller.dto.reqeust.SellerJudgeRequestDto;
import com.jeontongju.seller.dto.response.GetMySellerInfo;
import com.jeontongju.seller.dto.response.SellerInfoForConsumerDto;
import com.jeontongju.seller.dto.response.SellerInfoDetailsDto;
import com.jeontongju.seller.dto.response.SellerMyInfoDto;
import com.jeontongju.seller.dto.temp.SellerInfoDto;
import com.jeontongju.seller.exception.SellerEntityNotFoundException;
import com.jeontongju.seller.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SellerService {

  private final SellerRepository sellerRepository;

  public SellerInfoDto getSellerInfo(Long sellerId) {

    return SellerInfoDto.toDto(
        sellerRepository.findById(sellerId).orElseThrow(SellerEntityNotFoundException::new));
  }

  public SellerMyInfoDto getMySellerInfo(Long sellerId) {

    return SellerMyInfoDto.toDto(
        sellerRepository.findById(sellerId).orElseThrow(SellerEntityNotFoundException::new));
  }

  @Transactional
  public void modifySellerApprovalState(SellerJudgeRequestDto sellerJudgeRequestDto) {
    Seller seller =
        sellerRepository
            .findById(sellerJudgeRequestDto.getSellerId())
            .orElseThrow(SellerEntityNotFoundException::new);
    seller.setApprovalState(sellerJudgeRequestDto.getApprovalState());
  }

  public SellerInfoForConsumerDto getSellerOneForConsumer(Long sellerId) {

    return SellerInfoForConsumerDto.toDto(
        sellerRepository.findById(sellerId).orElseThrow(SellerEntityNotFoundException::new));
  }
  
  public SellerInfoDetailsDto getSellerOne(Long sellerId) {

    return SellerInfoDetailsDto.toDto(
        sellerRepository.findById(sellerId).orElseThrow(SellerEntityNotFoundException::new));
  }

  public GetMySellerInfo getMyInfo(Long sellerId) {

    return GetMySellerInfo.toDto(
            sellerRepository.findById(sellerId).orElseThrow(SellerEntityNotFoundException::new));
  }
}
