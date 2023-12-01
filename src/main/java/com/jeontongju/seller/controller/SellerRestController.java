package com.jeontongju.seller.controller;

import com.jeontongju.seller.dto.response.SellerInfoForAdminDto;
import com.jeontongju.seller.dto.response.SellerMyInfoDto;
import com.jeontongju.seller.dto.temp.ResponseFormat;
import com.jeontongju.seller.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

  @GetMapping("/admin/sellers")
  public ResponseEntity<ResponseFormat<Page<SellerInfoForAdminDto>>> getAllSeller(
      @RequestHeader Long memberId,
      String memberRole,
      @PageableDefault(
              page = 0,
              size = 10,
              sort = {"createdAt"},
              direction = Sort.Direction.DESC)
          Pageable pageable) {

    return ResponseEntity.ok()
        .body(
            ResponseFormat.<Page<SellerInfoForAdminDto>>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.name())
                .detail("모든 셀러 정보 조회 성공")
                .data(sellerService.getAllSeller(pageable))
                .build());
  }
}
