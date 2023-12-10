package com.jeontongju.seller.controller;

import com.jeontongju.seller.dto.response.SellerInfoForAuctionDto;
import com.jeontongju.seller.dto.temp.FeignFormat;
import com.jeontongju.seller.dto.temp.SellerInfoDto;
import com.jeontongju.seller.dto.temp.SignUpInfo;
import com.jeontongju.seller.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SellerClientController {

  private final SellerService sellerService;

  @GetMapping("/sellers/{sellerId}/name-image")
  FeignFormat<SellerInfoDto> getSellerInfoForCreateProduct(@PathVariable Long sellerId) {

    return FeignFormat.<SellerInfoDto>builder()
        .code(HttpStatus.OK.value())
        .data(sellerService.getSellerInfo(sellerId))
        .build();
  }

  @GetMapping("sellers/{sellerId}/auction")
  FeignFormat<SellerInfoForAuctionDto> getSellerInfoForAuction(@PathVariable Long sellerId) {

    return FeignFormat.<SellerInfoForAuctionDto>builder()
            .code(HttpStatus.OK.value())
            .data(sellerService.getSellerInfoForAuction(sellerId))
            .build();
  }

  @PostMapping("/sellers")
  FeignFormat<Void> saveSeller(@RequestBody SignUpInfo signUpInfo) {

    sellerService.saveSeller(signUpInfo);

    return FeignFormat.<Void>builder()
            .code(HttpStatus.OK.value())
            .build();
  }

}
