package com.jeontongju.seller.dto.response;

import com.jeontongju.seller.domain.Seller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerInfoDetails {

  private Long sellerId;
  private String email;
  private String storeName;
  private String storePhoneNumber;
  private String storeImageUrl;

  public static SellerInfoDetails toDto(Seller seller) {
    return SellerInfoDetails.builder()
        .sellerId(seller.getSellerId())
        .email(seller.getEmail())
        .storeName(seller.getStoreName())
        .storePhoneNumber(seller.getStorePhoneNumber())
        .storeImageUrl(seller.getStoreImageUrl())
        .build();
  }
}
