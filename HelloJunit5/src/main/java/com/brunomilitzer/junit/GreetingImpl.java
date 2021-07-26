package com.brunomilitzer.junit;

import com.brunomilitzer.junit.services.GreetingService;

public class GreetingImpl implements Greeting {

    private GreetingService service;

    @Override
    public String greet( final String name ) {

        return this.service.greet( name );

    }

}
