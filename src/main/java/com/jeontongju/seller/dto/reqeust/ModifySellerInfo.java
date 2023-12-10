package com.jeontongju.seller.dto.reqeust;

import javax.validation.constraints.Size;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModifySellerInfo {

  @Size(min = 1, max = 10, message = "가게 명은 1글자 이상 10 글자 이하만 입력 가능합니다.")
  private String storeName;

  @Size(min = 1, max = 50, message = "가게 설명은 1글자 이상 50 글자 이하만 입력 가능합니다.")
  private String storeDescription;

  private String storeImageUrl;

  private String storePhoneNumber;
}
