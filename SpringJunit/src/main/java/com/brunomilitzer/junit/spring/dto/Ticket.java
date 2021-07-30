package com.brunomilitzer.junit.spring.dto;

public class Ticket {

    private String passengerName;

    private String phone;

    public String getPassengerName() {

        return this.passengerName;
    }

    public void setPassengerName( final String passengerName ) {

        this.passengerName = passengerName;
    }

    public String getPhone() {

        return this.phone;
    }

    public void setPhone( final String phone ) {

        this.phone = phone;
    }

}
