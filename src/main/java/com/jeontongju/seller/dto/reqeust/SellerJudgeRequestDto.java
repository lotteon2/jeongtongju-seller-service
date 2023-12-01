package com.jeontongju.seller.dto.reqeust;

import com.jeontongju.seller.enums.ApprovalState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerJudgeRequestDto {
    private Long sellerId;
    private ApprovalState approvalState;
}
