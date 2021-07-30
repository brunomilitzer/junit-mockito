package com.brunomilitzer.junit.spring.dto;

import java.io.Serializable;

public class Order implements Serializable {

    private static final long serialVersionUID = 6360133879934129204L;

    Long id;

    String status;

    public Long getId() {

        return this.id;
    }

    public void setId( final Long id ) {

        this.id = id;
    }

    public String getStatus() {

        return this.status;
    }

    public void setStatus( final String status ) {

        this.status = status;
    }

}
