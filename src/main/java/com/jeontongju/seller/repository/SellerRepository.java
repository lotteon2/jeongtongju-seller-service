package com.jeontongju.seller.repository;

import com.jeontongju.seller.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {}
