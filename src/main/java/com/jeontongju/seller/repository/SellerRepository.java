package com.jeontongju.seller.repository;

import com.jeontongju.seller.domain.Seller;
import com.jeontongju.seller.dto.response.SellerInfoForAdminDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SellerRepository extends JpaRepository<Seller, Long> {

  @Query(
      "select new com.jeontongju.seller.dto.response.SellerInfoForAdminDto(s.sellerId, s.email, s.businessmanName, s.storeName, s.storePhoneNumber, s.createdAt, s.approvalState, s.isDeleted, s.storeDescription, s.storeImageUrl) from Seller s order by s.approvalState desc, s.createdAt")
  Page<SellerInfoForAdminDto> findAllSeller(Pageable pageable);
}
