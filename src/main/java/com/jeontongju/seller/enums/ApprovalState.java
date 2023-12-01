package com.jeontongju.seller.enums;

import lombok.Getter;

@Getter
public enum ApprovalState {
  WAIT("승인대기"),
  ALLOW("승인"),
  DENY("불허가");

  private final String value;

  ApprovalState(String value) {
    this.value = value;
  }
}
