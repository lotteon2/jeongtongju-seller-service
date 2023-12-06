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
public class GetSellerByAdminDto {

  private Long value;
  private String label;

  public static GetSellerByAdminDto toDto(Seller seller) {

    return GetSellerByAdminDto.builder()
        .value(seller.getSellerId())
        .label(seller.getStoreName())
        .build();
  }
}
