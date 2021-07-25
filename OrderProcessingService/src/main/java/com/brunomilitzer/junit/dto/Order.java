package com.brunomilitzer.junit.dto;

import java.io.Serializable;

public class Order implements Serializable {

    private static final long serialVersionUID = 6360133879934129204L;
    
    Long id;

    String status;

    public Long getId() {

        return id;
    }

    public void setId( Long id ) {

        this.id = id;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus( String status ) {

        this.status = status;
    }

}
