package com.brunomilitzer.junit.repository;

import com.brunomilitzer.junit.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    Coupon findByCode( String code );

}
