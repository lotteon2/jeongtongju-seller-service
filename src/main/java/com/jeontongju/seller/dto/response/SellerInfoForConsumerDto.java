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
public class SellerInfoForConsumerDto {

    private Long sellerId;
    private String storeName;
    private String storeDescription;
    private String storePhoneNumber;
    private String storeImageUrl;

    public static SellerInfoForConsumerDto toDto(Seller seller) {
        return SellerInfoForConsumerDto.builder()
                .sellerId(seller.getSellerId())
                .storeName(seller.getStoreName())
                .storeDescription(seller.getStoreDescription())
                .storePhoneNumber(seller.getStorePhoneNumber())
                .storeImageUrl(seller.getStoreImageUrl())
                .build();
    }
}
