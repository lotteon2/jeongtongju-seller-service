package com.jeontongju.seller.controller;

import com.jeontongju.seller.dto.reqeust.ModifySellerInfo;
import com.jeontongju.seller.dto.reqeust.SellerJudgeRequestDto;
import com.jeontongju.seller.dto.response.*;
import com.jeontongju.seller.dto.response.SellerInfoForConsumerDto;
import com.jeontongju.seller.dto.temp.ResponseFormat;
import com.jeontongju.seller.enums.temp.MemberRoleEnum;
import com.jeontongju.seller.service.SellerService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
      @RequestHeader Long memberId, @RequestHeader MemberRoleEnum memberRole) {

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
      @RequestHeader MemberRoleEnum memberRole,
      @PageableDefault(page = 0, size = 10) Pageable pageable) {

    return ResponseEntity.ok()
        .body(
            ResponseFormat.<Page<SellerInfoForAdminDto>>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.name())
                .detail("모든 셀러 정보 조회 성공")
                .data(sellerService.getAllSeller(pageable))
                .build());
  }

  @PatchMapping("/sellers/judge")
  public ResponseEntity<ResponseFormat<Void>> modifySellerApprovalState(
      @RequestHeader Long memberId,
      @RequestHeader MemberRoleEnum memberRole,
      @Valid @RequestBody SellerJudgeRequestDto sellerJudgeRequestDto) {

    sellerService.modifySellerApprovalState(sellerJudgeRequestDto);
    return ResponseEntity.ok()
        .body(
            ResponseFormat.<Void>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.name())
                .detail("셀러 승인 여부 변경 성공")
                .build());
  }

  @GetMapping("/sellers/{sellerId}/info")
  public ResponseEntity<ResponseFormat<SellerInfoForConsumerDto>> getSellerOneForConsumer(
      @PathVariable Long sellerId) {

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
      @RequestHeader Long memberId,
      @RequestHeader MemberRoleEnum memberRole) {

    return ResponseEntity.ok()
        .body(
            ResponseFormat.<SellerInfoDetailsDto>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.name())
                .detail("특정 셀러 정보 조회에 성공")
                .data(sellerService.getSellerOne(sellerId))
                .build());
  }

  @PatchMapping("/sellers")
  public ResponseEntity<ResponseFormat<Void>> modifySeller(
      @RequestHeader Long memberId,
      @RequestHeader MemberRoleEnum memberRole,
      @Valid @RequestBody ModifySellerInfo modifySellerInfo) {

    sellerService.modifySeller(memberId, modifySellerInfo);

    return ResponseEntity.ok()
        .body(
            ResponseFormat.<Void>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.name())
                .detail("개인 정보 수정 성공")
                .build());
  }

  @DeleteMapping("/sellers")
  public ResponseEntity<ResponseFormat<Void>> deleteSellerBySeller(
      @RequestHeader Long memberId, @RequestHeader MemberRoleEnum memberRole) {

    sellerService.deleteSeller(memberId);

    return ResponseEntity.ok()
        .body(
            ResponseFormat.<Void>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.name())
                .detail("셀러 탈퇴 성공")
                .build());
  }

  @DeleteMapping("/sellers/{sellerId}")
  public ResponseEntity<ResponseFormat<Void>> deleteSellerByAdmin(
      @RequestHeader Long memberId,
      @RequestHeader MemberRoleEnum memberRole,
      @PathVariable Long sellerId) {

    sellerService.deleteSeller(sellerId);

    return ResponseEntity.ok()
        .body(
            ResponseFormat.<Void>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.name())
                .detail("셀러 탈퇴 성공")
                .build());
  }

  @GetMapping("/sellers/info")
  public ResponseEntity<ResponseFormat<GetMySellerInfo>> getMyInfo(
      @RequestHeader Long memberId, @RequestHeader MemberRoleEnum memberRole) {

    return ResponseEntity.ok()
        .body(
            ResponseFormat.<GetMySellerInfo>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.name())
                .detail("내 정보 조회에 성공")
                .data(sellerService.getMyInfo(memberId))
                .build());
  }

  @GetMapping("/admin/sellers/info")
  public ResponseEntity<ResponseFormat<List<GetSellerByAdminDto>>> getSellerListByAdmin(
      @RequestHeader Long memberId, @RequestHeader MemberRoleEnum memberRole) {

    return ResponseEntity.ok()
        .body(
            ResponseFormat.<List<GetSellerByAdminDto>>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.name())
                .detail("셀러 id, 가게 이름 조회 성공")
                .data(sellerService.getSellerListByAdmin())
                .build());
  }
}
