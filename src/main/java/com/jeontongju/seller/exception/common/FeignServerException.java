package com.jeontongju.seller.exception.common;

public class FeignServerException extends RuntimeException {

  public FeignServerException(String message) {
    super(message);
  }
}
