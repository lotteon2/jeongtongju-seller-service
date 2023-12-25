package com.jeontongju.seller.dto.response;

import com.jeontongju.seller.domain.Seller;
import com.jeontongju.seller.enums.ApprovalState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetSellerForConsumerDto {

    private Long sellerId;
    private String email;
    private String businessmanName;
    private String storeName;
    private String storePhoneNumber;
    private LocalDateTime createdAt;
    private String storeDescription;
    private String storeImageUrl;

}
