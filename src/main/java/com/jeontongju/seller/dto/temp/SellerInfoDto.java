package com.jeontongju.seller.dto.temp;

import com.jeontongju.seller.domain.Seller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/** domain : seller
 * detail : 상품 등록 시, 들고 있을 셀러 정보
 * method : feign, kafka
 * comment : 등록 시, feign / 수정 시, kafka 로 product service 에 간다. */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerInfoDto {

  private String storeName;
  private String storeImageUrl;

  public static SellerInfoDto toDto(Seller seller) {
    return SellerInfoDto.builder()
        .storeName(seller.getStoreName())
        .storeImageUrl(seller.getStoreImageUrl())
        .build();
  }
}
