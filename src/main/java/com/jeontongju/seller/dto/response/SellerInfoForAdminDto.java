package com.jeontongju.seller.dto.response;

import com.jeontongju.seller.enums.ApprovalState;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerInfoForAdminDto {

  private Long sellerId;
  private String email;
  private String businessmanName;
  private String storeName;
  private String storePhoneNumber;
  private LocalDateTime createdAt;
  private ApprovalState approvalState;
  private Boolean isActivate;
  private String storeDescription;
  private String storeImageUrl;
}
