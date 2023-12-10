package com.jeontongju.seller.dto.response;

import com.jeontongju.seller.domain.Seller;
import com.jeontongju.seller.enums.ApprovalState;
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
  private ApprovalState approvalState;
  private Boolean isDeleted;

  public static SellerInfoDetailsDto toDto(Seller seller) {
    return SellerInfoDetailsDto.builder()
        .sellerId(seller.getSellerId())
        .email(seller.getEmail())
        .storeName(seller.getStoreName())
        .storePhoneNumber(seller.getStorePhoneNumber())
        .storeImageUrl(seller.getStoreImageUrl())
        .approvalState(seller.getApprovalState())
        .isDeleted(seller.getIsDeleted())
        .build();
  }
}
