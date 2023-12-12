package com.jeontongju.seller.mapper;

import com.jeontongju.seller.domain.Seller;
import com.jeontongju.seller.dto.temp.SellerInfoDto;
import com.jeontongju.seller.dto.temp.SellerInfoForAuctionDto;
import com.jeontongju.seller.dto.temp.SignUpInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SellerMapper {

  public Seller toSeller(SignUpInfo signUpInfo) {
    return Seller.builder()
        .sellerId(signUpInfo.getMemberId())
        .email(signUpInfo.getEmail())
        .storeName(signUpInfo.getStoreName())
        .storeDescription(signUpInfo.getStoreDescription())
        .storeImageUrl(signUpInfo.getStoreImageUrl())
        .storePhoneNumber(signUpInfo.getStorePhoneNumber())
        .businessmanName(signUpInfo.getBusinessmanName())
        .businessmanPhoneNumber(signUpInfo.getBusinessmanPhoneNumber())
        .build();
  }

  public SellerInfoDto toSellerInfoDto(Seller seller) {
    return SellerInfoDto.builder()
            .storeName(seller.getStoreName())
            .storeImageUrl(seller.getStoreImageUrl())
            .build();
  }

  public SellerInfoForAuctionDto toSellerInfoForAuctionDto(Seller seller) {

    return SellerInfoForAuctionDto.builder()
            .storeImageUrl(seller.getStoreImageUrl())
            .storeName(seller.getStoreName())
            .storeEmail(seller.getEmail())
            .storePhoneNumber(seller.getStorePhoneNumber())
            .businessmanName(seller.getBusinessmanName())
            .build();
  }
}
