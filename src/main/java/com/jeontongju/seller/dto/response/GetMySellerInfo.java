package com.jeontongju.seller.dto.response;

import com.jeontongju.seller.domain.Seller;
import com.jeontongju.seller.enums.ApprovalState;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class GetMySellerInfo {

    private Long sellerId;
    private String storeName;
    private String storeImageUrl;
    private ApprovalState approvalState;

    public static GetMySellerInfo toDto(Seller seller) {
        return GetMySellerInfo.builder()
                .sellerId(seller.getSellerId())
                .storeName(seller.getStoreName())
                .storeImageUrl(seller.getStoreImageUrl())
                .approvalState(seller.getApprovalState())
                .build();
    }
}
