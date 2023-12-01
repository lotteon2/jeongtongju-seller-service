package com.jeontongju.seller.controller;

import com.jeontongju.seller.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class SellerRestController {

  private final SellerService sellerService;
}
