package com.jeontongju.seller.dto.temp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpInfo {

  private Long memberId;
  private String email;
  private String storeName;
  private String storeDescription;
  private String storeImageUrl;
  private String storePhoneNumber;
  private String businessmanName;
  private String businessmanPhoneNumber;
}
