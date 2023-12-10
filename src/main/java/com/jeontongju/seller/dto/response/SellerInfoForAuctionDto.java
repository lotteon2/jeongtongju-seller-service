package com.jeontongju.seller.dto.response;

import com.jeontongju.seller.domain.Seller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerInfoForAuctionDto {
  private String storeImageUrl;
  private String storeName;
  private String storeEmail;
  private String storePhoneNumber;
  private String businessmanName;

  public static SellerInfoForAuctionDto toDto(Seller seller) {

    return SellerInfoForAuctionDto.builder()
        .storeImageUrl(seller.getStoreImageUrl())
        .storeName(seller.getStoreName())
        .storeEmail(seller.getEmail())
        .storePhoneNumber(seller.getStorePhoneNumber())
        .businessmanName(seller.getBusinessmanName())
        .build();
  }
}
