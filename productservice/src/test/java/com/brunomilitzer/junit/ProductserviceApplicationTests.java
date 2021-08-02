package com.brunomilitzer.junit;

import com.brunomilitzer.junit.controller.ProductRestController;
import com.brunomilitzer.junit.dto.Coupon;
import com.brunomilitzer.junit.entities.Product;
import com.brunomilitzer.junit.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductserviceApplicationTests {

    private static final String COUPON_SERVICE_URL = "http://localhost:9091/couponapi/coupons/";

    private static final String COUPON_CODE = "TESTSALE";

    private static final BigDecimal DISCOUNT = BigDecimal.valueOf( 20 );

    @Mock
    private RestTemplate template;

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductRestController controller;

    @Test
    void testCreateProduct() {

        final Coupon coupon = new Coupon();
        coupon.setCode( COUPON_CODE );
        coupon.setDiscount( DISCOUNT );

        final Product product = new Product();
        product.setCouponCode( COUPON_CODE );
        product.setPrice( new BigDecimal( 900 ) );

        this.controller.setCouponServiceUrl( COUPON_SERVICE_URL );

        when( this.template.getForObject( COUPON_SERVICE_URL + COUPON_CODE, Coupon.class ) ).thenReturn( coupon );
        when( this.repository.save( product ) ).thenReturn( product );

        final Product productResponse = this.controller.create( product );
        verify( this.template ).getForObject( COUPON_SERVICE_URL + COUPON_CODE, Coupon.class );
        verify( this.repository ).save( product );
        assertNotNull( productResponse );
        assertEquals( COUPON_CODE, productResponse.getCouponCode() );
    }

}
