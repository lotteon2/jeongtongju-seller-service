package com.jeontongju.seller.dto.reqeust;

import com.jeontongju.seller.enums.ApprovalState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerJudgeRequestDto {
    @NotNull(message = "null 값이 불가합니다.")
    private Long sellerId;
    @NotNull(message = "null 값이 불가합니다.")
    private ApprovalState approvalState;
}
