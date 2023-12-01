package com.jeontongju.seller.exception;

import com.jeontongju.seller.exception.common.EntityNotFoundException;

public class SellerEntityNotFoundException extends EntityNotFoundException {

  private static final String message = "셀러를 찾을 수 없습니다.";

  public SellerEntityNotFoundException() {
    super(message);
  }
}
