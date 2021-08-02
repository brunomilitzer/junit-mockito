package com.brunomilitzer.junit.controller;

import com.brunomilitzer.junit.dto.Coupon;
import com.brunomilitzer.junit.entities.Product;
import com.brunomilitzer.junit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping( "/productapi" )
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value( "${couponService.url}" )
    private String couponServiceUrl;

    @PostMapping( value = "/products" )
    public Product create( @RequestBody final Product product ) {

        final Coupon coupon = this.restTemplate.getForObject( this.couponServiceUrl + product.getCouponCode(), Coupon.class );

        if ( coupon != null ) {
            product.setPrice( product.getPrice().subtract( coupon.getDiscount() ) );
        }

        return this.productRepository.save( product );
    }

    public String getCouponServiceUrl() {

        return this.couponServiceUrl;
    }

    public void setCouponServiceUrl( final String couponServiceUrl ) {

        this.couponServiceUrl = couponServiceUrl;
    }

}
