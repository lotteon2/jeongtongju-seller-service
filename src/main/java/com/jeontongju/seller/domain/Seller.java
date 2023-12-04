package com.jeontongju.seller.domain;

import com.jeontongju.seller.domain.common.BaseEntity;
import com.jeontongju.seller.dto.reqeust.ModifySellerInfo;
import com.jeontongju.seller.enums.ApprovalState;
import javax.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
@Table(name = "seller")
public class Seller extends BaseEntity {

  @Id
  @Column(name = "seller_id")
  private Long sellerId;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "store_name", nullable = false, length = 10)
  private String storeName;

  @Column(name = "store_description", nullable = false, length = 50)
  private String storeDescription;

  @Column(name = "store_image_url", nullable = false)
  private String storeImageUrl;

  @Column(name = "store_phone_number", nullable = false)
  private String storePhoneNumber;

  @Column(name = "businessman_name", nullable = false)
  private String businessmanName;

  @Column(name = "businessman_phone_number", nullable = false)
  private String businessmanPhoneNumber;

  @Builder.Default
  @Enumerated(EnumType.STRING)
  @Column(
      name = "approval_state",
      nullable = false,
      columnDefinition = "VARCHAR(255) DEFAULT 'WAIT'")
  private ApprovalState approvalState = ApprovalState.WAIT;

  @Builder.Default
  @Column(name = "is_deleted", nullable = false)
  private Boolean isDeleted = false;

  public void setStoreName(String storeName) {
    if (storeName != null) {
      this.storeName = storeName;
    }
  }

  public void setStoreDescription(String storeDescription) {
    if (storeDescription != null) {
      this.storeDescription = storeDescription;
    }
  }

  public void setStoreImageUrl(String storeImageUrl) {
    if (storeImageUrl != null) {
      this.storeImageUrl = storeImageUrl;
    }
  }

  public void setStorePhoneNumber(String storePhoneNumber) {
    if (storePhoneNumber != null) {
      this.storePhoneNumber = storePhoneNumber;
    }
  }

  public void setApprovalState(ApprovalState approvalState) {
    this.approvalState = approvalState;
  }

  public void setDeleted(Boolean deleted) {
    this.isDeleted = deleted;
  }

  public void modifySeller(ModifySellerInfo modifySellerInfo) {
    setStoreName(modifySellerInfo.getStoreName());
    setStoreDescription(modifySellerInfo.getStoreDescription());
    setStorePhoneNumber(modifySellerInfo.getStorePhoneNumber());
    setStoreImageUrl(modifySellerInfo.getStoreImageUrl());
  }
}
