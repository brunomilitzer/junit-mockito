package com.brunomilitzer.junit;

import com.brunomilitzer.junit.controllers.CouponRestController;
import com.brunomilitzer.junit.entities.Coupon;
import com.brunomilitzer.junit.repository.CouponRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CouponserviceApplicationTests {

    private static final String COUPON_CODE = "TESTSALE";
    private static final BigDecimal DISCOUNT = BigDecimal.valueOf( 20L );

    @Mock
    private CouponRepository repository;

    @InjectMocks
    private CouponRestController controller;

    @Test
    void testCreate() {

        final Coupon coupon = new Coupon();
        coupon.setCode( COUPON_CODE );
        when( this.repository.save( coupon ) ).thenReturn( coupon );
        this.controller.create( coupon );
        verify( this.repository ).save( coupon );
        assertNotNull( coupon );
        assertEquals( COUPON_CODE, coupon.getCode() );
    }

    @Test
    void testGetCoupon() {

        final Coupon coupon = new Coupon();
        coupon.setId( 1L );
        coupon.setCode( COUPON_CODE );
        coupon.setDiscount( DISCOUNT );
        coupon.setExpDate( "12/21" );

        when( this.repository.findByCode( COUPON_CODE ) ).thenReturn( coupon );
        final Coupon couponResponse = this.controller.getCoupon( COUPON_CODE );
        verify( this.repository ).findByCode( COUPON_CODE );
        assertNotNull( couponResponse );
        assertEquals( COUPON_CODE, couponResponse.getCode() );
        assertEquals( DISCOUNT, couponResponse.getDiscount() );
    }

    @Test
    public void testCrate_WHEN_COUPON_IS_NULL_THROWS_EXCEPTION() {

        assertThrows( IllegalArgumentException.class, () -> this.controller.create( null ) );
    }

    @Test
    public void testgetCoupon_WHEN_COUPON_CODE_IS_NULL_THROWS_EXCEPTION() {

        assertThrows( IllegalArgumentException.class, () -> this.controller.getCoupon( null ) );
    }

    @Test
    public void testgetCoupon_WHEN_COUPON_CODE_IS_EMPTY_THROWS_EXCEPTION() {

        assertThrows( IllegalArgumentException.class, () -> this.controller.getCoupon( "" ) );
    }

}
