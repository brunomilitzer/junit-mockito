package com.brunomilitzer.junit.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = -1864584326564666844L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    @Transient
    private String couponCode;

    public Long getId() {

        return this.id;
    }

    public void setId( final Long id ) {

        this.id = id;
    }

    public String getName() {

        return this.name;
    }

    public void setName( final String name ) {

        this.name = name;
    }

    public String getDescription() {

        return this.description;
    }

    public void setDescription( final String description ) {

        this.description = description;
    }

    public BigDecimal getPrice() {

        return this.price;
    }

    public void setPrice( final BigDecimal price ) {

        this.price = price;
    }

    public String getCouponCode() {

        return this.couponCode;
    }

    public void setCouponCode( final String code ) {

        this.couponCode = code;
    }

}
