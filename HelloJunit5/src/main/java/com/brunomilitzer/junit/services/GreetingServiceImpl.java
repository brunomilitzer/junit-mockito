package com.brunomilitzer.junit.services;

public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greet( final String name ) {

        if ( name == null || name.length() == 0 ) {
            throw new IllegalArgumentException();
        }

        return "Hello " + name;
    }

}
