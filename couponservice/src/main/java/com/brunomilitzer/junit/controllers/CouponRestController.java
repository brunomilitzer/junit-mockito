package com.brunomilitzer.junit.controllers;

import com.brunomilitzer.junit.entities.Coupon;
import com.brunomilitzer.junit.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/couponapi" )
public class CouponRestController {

    @Autowired
    private CouponRepository couponRepository;

    @PostMapping( value = "/coupons" )
    public Coupon create( @RequestBody final Coupon coupon ) {

        if ( coupon == null ) {
            throw new IllegalArgumentException( "COUPON IS REQUIRED" );

        }
        return this.couponRepository.save( coupon );
    }

    @GetMapping( value = "/coupons/{code}" )
    public Coupon getCoupon( @PathVariable( "code" ) final String code ) {

        if ( code == null || code.length() == 0 ) {
            throw new IllegalArgumentException( "COUPON CODE IS REQUIRED" );
        }
        return this.couponRepository.findByCode( code );
    }

}
