package com.jeontongju.seller.controller;

import com.jeontongju.seller.dto.reqeust.SellerJudgeRequestDto;
import com.jeontongju.seller.dto.response.SellerMyInfoDto;
import com.jeontongju.seller.dto.temp.ResponseFormat;
import com.jeontongju.seller.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class SellerRestController {

  private final SellerService sellerService;

  @GetMapping("/sellers")
  public ResponseEntity<ResponseFormat<SellerMyInfoDto>> getMySellerInfo(
      @RequestHeader Long memberId, String memberRole) {

    return ResponseEntity.ok()
        .body(
            ResponseFormat.<SellerMyInfoDto>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.name())
                .detail("셀러 자신의 정보 조회 성공")
                .data(sellerService.getMySellerInfo(memberId))
                .build());
  }

  @PatchMapping("/sellers/judge")
  public ResponseEntity<ResponseFormat<Void>> modifySellerApprovalState(
      @RequestHeader Long memberId,
      String memberRole,
      @RequestBody SellerJudgeRequestDto sellerJudgeRequestDto) {

    sellerService.modifySellerApprovalState(sellerJudgeRequestDto);
    return ResponseEntity.ok()
        .body(
            ResponseFormat.<Void>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.name())
                .detail("셀러 승인 여부 변경 성공")
                .build());
  }
}
