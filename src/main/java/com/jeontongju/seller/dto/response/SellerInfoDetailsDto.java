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
public class SellerInfoDetailsDto {

  private Long sellerId;
  private String email;
  private String storeName;
  private String storePhoneNumber;
  private String storeImageUrl;

  public static SellerInfoDetailsDto toDto(Seller seller) {
    return SellerInfoDetailsDto.builder()
        .sellerId(seller.getSellerId())
        .email(seller.getEmail())
        .storeName(seller.getStoreName())
        .storePhoneNumber(seller.getStorePhoneNumber())
        .storeImageUrl(seller.getStoreImageUrl())
        .build();
  }
}
