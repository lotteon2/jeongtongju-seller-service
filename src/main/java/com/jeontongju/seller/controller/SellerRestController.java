package com.jeontongju.seller.controller;

import com.jeontongju.seller.dto.response.SellerInfoForConsumerDto;
import com.jeontongju.seller.dto.response.SellerInfoDetailsDto;
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
  public ResponseEntity<ResponseFormat<SellerMyInfoDto>> getMySellerInfo(@RequestHeader Long memberId, String memberRole) {

    return ResponseEntity.ok()
            .body(
                    ResponseFormat.<SellerMyInfoDto>builder()
                            .code(HttpStatus.OK.value())
                            .message(HttpStatus.OK.name())
                            .detail("셀러 자신의 정보 조회 성공")
                            .data(sellerService.getMySellerInfo(memberId))
                            .build());
  }

  @GetMapping("/sellers/{sellerId}/info")
  public ResponseEntity<ResponseFormat<SellerInfoForConsumerDto>> getSellerOneForConsumer(@PathVariable Long sellerId) {

    return ResponseEntity.ok()
            .body(
                    ResponseFormat.<SellerInfoForConsumerDto>builder()
                            .code(HttpStatus.OK.value())
                            .message(HttpStatus.OK.name())
                            .detail("셀러 정보 조회 성공")
                            .data(sellerService.getSellerOneForConsumer(sellerId))
                                  .build());
  }

  @GetMapping("/sellers/{sellerId}")
  public ResponseEntity<ResponseFormat<SellerInfoDetailsDto>> getSellerOne(
          @PathVariable Long sellerId,
          @RequestHeader Long memberId, String memberRole) {

    return ResponseEntity.ok()
            .body(
                    ResponseFormat.<SellerInfoDetailsDto>builder()
                            .code(HttpStatus.OK.value())
                            .message(HttpStatus.OK.name())
                            .detail("특정 셀러 정보 조회에 성공")
                            .data(sellerService.getSellerOne(sellerId))
                            .build());
  }
}
